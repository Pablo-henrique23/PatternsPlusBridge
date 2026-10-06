package org.example;

public class Telemetria implements Dispositivo {

    @Override
    public String coletarDados() {
        return "Dados coletados pela telemetria";
    }
}