package org.example;

public class Monitor implements Dispositivo {

    @Override
    public String coletarDados() {
        return "Dados coletados pelo monitor";
    }
}