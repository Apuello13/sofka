package com.sofka.prueba.PruebaSofka.utility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtTokenProvider {
    public String generateToken(String username){
        List<GrantedAuthority> authorities = new ArrayList<>();
        return Jwts.builder().setSubject(username)
                .claim("authorities",
                        authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JwtConstantes.TOKEN_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, JwtConstantes.SUPER_SECRET_KEY.getBytes())
                .compact();
    }
}
