package com.sofka.prueba.PruebaSofka.service;

import com.sofka.prueba.PruebaSofka.domain.Usuario;
import com.sofka.prueba.PruebaSofka.dto.GreetingDTO;
import com.sofka.prueba.PruebaSofka.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> findUsers();
    GreetingDTO getGreeting(Long idUsuario);
    Usuario findByUsername(String username, String contraseña);
}