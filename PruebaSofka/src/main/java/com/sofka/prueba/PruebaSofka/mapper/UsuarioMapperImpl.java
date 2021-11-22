package com.sofka.prueba.PruebaSofka.mapper;

import com.sofka.prueba.PruebaSofka.domain.Usuario;
import com.sofka.prueba.PruebaSofka.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapperImpl implements UsuarioMapper{
    @Override
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        if(usuario == null)
            return null;
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre(usuario.getNombre());
        return usuarioDTO;
    }
}
