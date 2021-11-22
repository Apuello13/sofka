package com.sofka.prueba.PruebaSofka.controller;

import com.sofka.prueba.PruebaSofka.dto.AuthDTO;
import com.sofka.prueba.PruebaSofka.dto.AuthLoginDTO;
import com.sofka.prueba.PruebaSofka.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
@CrossOrigin( origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private AuthService authService;

    //POST
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO authDTO){
        AuthLoginDTO auth = authService.login(authDTO);
        if(Objects.isNull(auth))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(auth, HttpStatus.OK);
    }
}