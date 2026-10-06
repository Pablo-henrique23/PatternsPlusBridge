package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonitoramentoTest {

    @Test
    void deveSerSingleton() {
        CentralMonitoramento central1 = CentralMonitoramento.getInstance();
        CentralMonitoramento central2 = CentralMonitoramento.getInstance();

        assertSame(central1, central2);
    }

    @Test
    void deveCriarMonitoramentoCardiacoNaUTI() {
        FabricaAbstrata fabrica = new FabricaUTI();
        Dispositivo dispositivo = new Monitor();

        Monitoramento monitoramento =
                fabrica.criarMonitoramento(dispositivo);

        assertInstanceOf(MonitoramentoCardiaco.class, monitoramento);
    }

    @Test
    void deveCriarMonitoramentoSinaisVitaisNaEnfermaria() {
        FabricaAbstrata fabrica = new FabricaEnfermaria();
        Dispositivo dispositivo = new Telemetria();

        Monitoramento monitoramento =
                fabrica.criarMonitoramento(dispositivo);

        assertInstanceOf(MonitoramentoSinaisVitais.class, monitoramento);
    }

    @Test
    void deveIntegrarMonitoramentoComDispositivo() {
        Dispositivo dispositivo = new Monitor();

        Monitoramento monitoramento =
                new MonitoramentoCardiaco(dispositivo);

        assertTrue(monitoramento.monitorar().contains("Dados coletados pelo monitor"));
    }

    @Test
    void deveAdicionarMonitoramentoNaCentral() {
        CentralMonitoramento central =
                CentralMonitoramento.getInstance();

        Monitoramento monitoramento =
                new MonitoramentoCardiaco(new Monitor());

        central.adicionarMonitoramento(monitoramento);

        assertTrue(central.getMonitoramentos().contains(monitoramento));
    }
}