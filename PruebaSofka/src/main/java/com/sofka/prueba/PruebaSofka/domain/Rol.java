package com.sofka.prueba.PruebaSofka.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "roles" )
public class Rol implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne
    @JoinColumn( name = "id_usuario", foreignKey = @ForeignKey( name = "FK_ID_USUARIO" ) )
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
