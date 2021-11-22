package com.sofka.prueba.PruebaSofka.service;

import com.sofka.prueba.PruebaSofka.domain.Usuario;
import com.sofka.prueba.PruebaSofka.dto.GreetingDTO;
import com.sofka.prueba.PruebaSofka.dto.UsuarioDTO;
import com.sofka.prueba.PruebaSofka.mapper.UsuarioMapper;
import com.sofka.prueba.PruebaSofka.repository.UsuarioRepository;
import com.sofka.prueba.PruebaSofka.utility.GreetingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl extends GreetingProvider implements UsuarioService {
    //Repository
    @Autowired
    private UsuarioRepository usuarioRepository;
    //Mappers
    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> findUsers() {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try{
            usuarios = usuarioRepository.findAll().stream()
                    .map(usuario -> usuarioMapper.usuarioToUsuarioDTO(usuario))
                    .collect(Collectors.toList());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return usuarios;
    }

    @Override
    public GreetingDTO getGreeting(Long idUsuario) {
        GreetingDTO greeting = new GreetingDTO();
        try{
            Usuario usuario = usuarioRepository.getById(idUsuario);
            greeting.setGreeting(greeting(usuario.getNombre()));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return greeting;
    }

    @Override
    public Usuario findByUsername(String username, String contraseña) {
        Usuario usuario = new Usuario();
        try{
            usuario = usuarioRepository.findByUsernameAndContraseña(username, contraseña);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return usuario;
    }
}