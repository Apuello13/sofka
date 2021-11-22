package com.sofka.prueba.PruebaSofka.mapper;

import com.sofka.prueba.PruebaSofka.domain.Usuario;
import com.sofka.prueba.PruebaSofka.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper {
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
}
