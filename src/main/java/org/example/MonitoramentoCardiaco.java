package org.example;

public class MonitoramentoCardiaco implements Monitoramento {

    private final Dispositivo dispositivo;

    public MonitoramentoCardiaco(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public String monitorar() {
        return "Monitoramento cardíaco: " + dispositivo.coletarDados();
    }
}