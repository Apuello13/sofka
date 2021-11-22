package com.sofka.prueba.PruebaSofka.controller;

import com.sofka.prueba.PruebaSofka.dto.GreetingDTO;
import com.sofka.prueba.PruebaSofka.dto.UsuarioDTO;
import com.sofka.prueba.PruebaSofka.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UsuarioService usuarioService;

    //GET
    @GetMapping("/greet/{id}")
    public ResponseEntity<?> getGreeting(@PathVariable("id") Long idUsuario){
        GreetingDTO greeting = usuarioService.getGreeting(idUsuario);
        if(greeting == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(greeting, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getUsers(){
        List<UsuarioDTO> usuarios = usuarioService.findUsers();
        if(Objects.isNull(usuarios))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(usuarios, HttpStatus.OK);
    }
}