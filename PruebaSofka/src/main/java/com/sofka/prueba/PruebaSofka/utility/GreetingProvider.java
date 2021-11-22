package com.sofka.prueba.PruebaSofka.utility;

public class GreetingProvider {
    public String greeting(String nombre){
        int numeroRandom = (int) (Math.random() * 3);
        String greeting = "";
        switch (numeroRandom){
            case 0:
                greeting = "Hello " + nombre; //Ingles
                break;
            case 1:
                greeting = "Ciao " + nombre; //Italiano
                break;
            case 2:
                greeting = "こんにちは " + nombre; //Japones
                break;
        }
        return greeting;
    }
}
