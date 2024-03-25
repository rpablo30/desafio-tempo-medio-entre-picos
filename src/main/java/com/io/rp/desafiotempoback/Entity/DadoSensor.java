package com.io.rp.desafiotempoback.Entity;

import lombok.Data;

@Data
public class DadoSensor {

    private int segundos;
    private int minutos;
    private int valor;
    private int tempo;
    private boolean pico;
    private double tempoDosPicos;
    private double tempoMedioEntrePicos;
    private double difTempPico1Pico2;
    private double difTempPico2Pico3;
    private double difTempPico3Pico4;

    public DadoSensor(int segundos, int minutos, int valor, int tempo, boolean pico) {
        this.segundos = segundos;
        this.minutos = minutos;
        this.valor = valor;
        this.tempo = tempo;
        this.pico = pico;
    }
}
