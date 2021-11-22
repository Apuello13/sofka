package com.sofka.prueba.PruebaSofka.service;

import com.sofka.prueba.PruebaSofka.dto.AuthDTO;
import com.sofka.prueba.PruebaSofka.dto.AuthLoginDTO;

public interface AuthService {
    AuthLoginDTO login(AuthDTO authDTO);
}