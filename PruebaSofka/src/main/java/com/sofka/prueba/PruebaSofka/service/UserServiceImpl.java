package com.sofka.prueba.PruebaSofka.service;

import com.sofka.prueba.PruebaSofka.domain.Usuario;
import com.sofka.prueba.PruebaSofka.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String contraseña = "";
        Usuario usuario = usuarioRepository.findByUsernameAndContraseña(username, contraseña);
        if(Objects.isNull(usuario)){
            throw new UsernameNotFoundException("No existe el usuario " + username + "en el sistema");
        }
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        //usuario.getRoles().stream().map(rol -> grantedAuths.add(rol.getNombre()));
        return new User(usuario.getUsername(), usuario.getContraseña(), grantedAuths);
    }
}
