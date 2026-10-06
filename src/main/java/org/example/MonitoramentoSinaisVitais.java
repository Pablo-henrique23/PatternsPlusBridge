package org.example;

public class MonitoramentoSinaisVitais implements Monitoramento {

    private final Dispositivo dispositivo;

    public MonitoramentoSinaisVitais(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public String monitorar() {
        return "Monitoramento de sinais vitais: " + dispositivo.coletarDados();
    }
}