package com.sofka.prueba.PruebaSofka.security;

import com.sofka.prueba.PruebaSofka.utility.JwtConstantes;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (isExistsToken(request, response)) {
                Claims claims = validateToken(request);
                setUpSpringAuthentication(claims);
            }else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        }catch(Exception e) {
            e.printStackTrace();
            SecurityContextHolder.clearContext();
        }
    }

    public boolean isExistsToken(HttpServletRequest request, HttpServletResponse response){
        String authHeader = request.getHeader(JwtConstantes.HEADER_AUTHORIZACION_KEY);
        if (authHeader == null || !authHeader.startsWith(JwtConstantes.TOKEN_BEARER_PREFIX)) {
            return false;
        }
        return true;
    }

    private void setUpSpringAuthentication(Claims claims) {
        Object subjet = claims.get("sub");
        Object authorities = claims.get("authorities");

        ArrayList<String > roles = (ArrayList<String>)authorities;
        List<GrantedAuthority> grantedAuths = new ArrayList<>();

        for(String rol : roles) {
            grantedAuths.add(new SimpleGrantedAuthority(rol));
        }
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(subjet, subjet, grantedAuths);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @SuppressWarnings("deprecation")
    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(JwtConstantes.HEADER_AUTHORIZACION_KEY)
                .replace(JwtConstantes.TOKEN_BEARER_PREFIX, "");
        return Jwts.
                parser().
                setSigningKey(JwtConstantes.SUPER_SECRET_KEY.getBytes()).
                parseClaimsJws(jwtToken)
                .getBody();
    }
}
