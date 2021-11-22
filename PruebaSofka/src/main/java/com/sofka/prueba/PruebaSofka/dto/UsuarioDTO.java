package com.sofka.prueba.PruebaSofka.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}