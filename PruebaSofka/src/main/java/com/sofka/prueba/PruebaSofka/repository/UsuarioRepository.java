package com.sofka.prueba.PruebaSofka.repository;

import com.sofka.prueba.PruebaSofka.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsernameAndContraseña(String username, String contraseña);
}