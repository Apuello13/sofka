package com.sofka.prueba.PruebaSofka.dto;

import java.io.Serializable;

public class GreetingDTO implements Serializable {
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
