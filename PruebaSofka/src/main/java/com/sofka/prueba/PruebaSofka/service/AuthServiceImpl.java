package com.sofka.prueba.PruebaSofka.service;

import com.sofka.prueba.PruebaSofka.domain.Usuario;
import com.sofka.prueba.PruebaSofka.dto.AuthDTO;
import com.sofka.prueba.PruebaSofka.dto.AuthLoginDTO;
import com.sofka.prueba.PruebaSofka.utility.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl extends JwtTokenProvider implements AuthService{
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public AuthLoginDTO login(AuthDTO authDTO) {
        AuthLoginDTO authLoginDTO = new AuthLoginDTO();
        try{
            Usuario usuario = usuarioService.findByUsername(authDTO.getUsername(), authDTO.getPassword());
            if(usuario == null)
                return null;
            authLoginDTO.setToken(generateToken(usuario.getUsername()));
            authLoginDTO.setId(usuario.getId());
        }catch(Exception e){
            e.printStackTrace();
        }
        return authLoginDTO;
    }
}