package com.io.rp.desafiotempoback.Service;

import com.io.rp.desafiotempoback.Entity.DadoSensor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DadoSensorService {

    private List<DadoSensor> dadosDoSensor = new ArrayList<>();

    public DadoSensorService() {
        initializeDadosDoSensor();
    }

    private void initializeDadosDoSensor() {
        dadosDoSensor.add(new DadoSensor(0, 0, 31, 0, false));
        dadosDoSensor.add(new DadoSensor(2, 0, 31, 0, false));
        dadosDoSensor.add(new DadoSensor(3, 0, 27, 0, false));
        dadosDoSensor.add(new DadoSensor(5, 0, 14, 0, false));
        dadosDoSensor.add(new DadoSensor(11, 0, 70, 0, true));
        dadosDoSensor.add(new DadoSensor(12, 0, 52, 0, false));
        dadosDoSensor.add(new DadoSensor(14, 0, 57, 0, false));
        dadosDoSensor.add(new DadoSensor(16, 0, 37, 0, false));
        dadosDoSensor.add(new DadoSensor(18, 0, 42, 0, false));
        dadosDoSensor.add(new DadoSensor(21, 0, 15, 0, false));
        dadosDoSensor.add(new DadoSensor(25, 0, 57, 0, false));
        dadosDoSensor.add(new DadoSensor(27, 0, 55, 0, false));
        dadosDoSensor.add(new DadoSensor(28, 0, 64, 0, true));
        dadosDoSensor.add(new DadoSensor(29, 0, 54, 0, false));
        dadosDoSensor.add(new DadoSensor(31, 0, 58, 0, false));
        dadosDoSensor.add(new DadoSensor(40, 0, 30, 0, false));
        dadosDoSensor.add(new DadoSensor(42, 0, 78, 0, true));
        dadosDoSensor.add(new DadoSensor(46, 0, 45, 0, false));
        dadosDoSensor.add(new DadoSensor(47, 0, 49, 0, false));
        dadosDoSensor.add(new DadoSensor(52, 0, 6, 0, false));
        dadosDoSensor.add(new DadoSensor(53, 0, 5, 0, false));
        dadosDoSensor.add(new DadoSensor(59, 0, 66, 0, true));
        dadosDoSensor.add(new DadoSensor(61, 0, 51, 0, false));
        dadosDoSensor.add(new DadoSensor(63, 0, 55, 0, false));
        dadosDoSensor.add(new DadoSensor(65, 0, 41, 0, false));
    }

    public List<Map<String, Integer>> obterPontosDoGrafico() {
        List<Map<String, Integer>> pontosDoGrafico = new ArrayList<>();
        for (DadoSensor dado : dadosDoSensor) {
            Map<String, Integer> ponto = new HashMap<>();
            ponto.put("segundos", dado.getSegundos());
            ponto.put("valor", dado.getValor());
            pontosDoGrafico.add(ponto);
        }
        return pontosDoGrafico;
    }


    public List<Integer> obterValoresDosPicos() {
        List<Integer> valoresDosPicos = new ArrayList<>();
        for (DadoSensor dado : dadosDoSensor) {
            if (dado.isPico()) {
                valoresDosPicos.add(dado.getValor());
            }
        }
        return valoresDosPicos;
    }

    public List<Integer> gerandoTempoMedioEntrePicos() {
        List<Integer> valoresDosPicos = new ArrayList<>();
        for (DadoSensor dado : dadosDoSensor) {
            if (dado.isPico()) {
                valoresDosPicos.add(dado.getValor());
            }
        }
        return valoresDosPicos;
    }

    public void calcularEMarcarTempoMedioEntrePicos() {
        List<Integer> valoresDosPicos = gerandoTempoMedioEntrePicos();

        if (valoresDosPicos.size() >= 4) {
            int soma = 0;
            for (int i = 0; i < 4; i++) {
                soma += valoresDosPicos.get(i);
            }
            int media = soma / 4;

            for (DadoSensor dado : dadosDoSensor) {
                if (dado.isPico()) {
                    dado.setTempoDosPicos(media);
                }
            }
        }
    }

    public int calcularSomaDosQuatroPrimeirosPicos() {
        List<Integer> valoresDosPicos = gerandoTempoMedioEntrePicos();
        int soma = 0;
        for (int i = 0; i < 4 && i < valoresDosPicos.size(); i++) {
            soma += valoresDosPicos.get(i);
        }
        return soma;
    }

    public double calcularMediaDosQuatroPrimeirosPicos() {
        int soma = calcularSomaDosQuatroPrimeirosPicos();
        return (double) soma / 4.0;
    }

    public List<Integer> calcularDiferencasDeTempoEntrePicos() {
        List<Integer> temposDosPicos = new ArrayList<>();
        List<Integer> valoresDosPicos = obterValoresDosPicos();

        for (DadoSensor dado : dadosDoSensor) {
            if (valoresDosPicos.contains(dado.getValor())) {
                temposDosPicos.add(dado.getSegundos());
            }
        }

        List<Integer> diferencaDeTemposEntrePicos = new ArrayList<>();
        for (int i = 0; i < temposDosPicos.size() - 1; i++) {
            diferencaDeTemposEntrePicos.add(Math.abs(temposDosPicos.get(i) - temposDosPicos.get(i + 1)));
        }

        return diferencaDeTemposEntrePicos;
    }



    public Map<String, Object> obterInfoDosPicos() {
        calcularEMarcarTempoMedioEntrePicos();

        List<DadoSensor> picos = new ArrayList<>();
        for (DadoSensor dado : dadosDoSensor) {
            if (dado.isPico()) {
                picos.add(dado);
            }
        }

        Map<String, Object> infoPicos = new LinkedHashMap<>();
        for (int i = 0; i < picos.size(); i++) {
            DadoSensor pico = picos.get(i);
            Map<String, Object> picoInfo = new LinkedHashMap<>();
            picoInfo.put("Valor", pico.getValor());

            if (pico.getSegundos() >= 60) {
                int minutos = pico.getSegundos() / 60;
                int segundosRestantes = pico.getSegundos() % 60;
                picoInfo.put("Tempo", String.format("%02d:%02d minutos e %02d segundos", minutos, segundosRestantes, pico.getMinutos()));
            } else {
                picoInfo.put("Tempo", String.format("%02d:%02d segundos", pico.getMinutos(), pico.getSegundos()));
            }
            infoPicos.put("Pico " + (i + 1), picoInfo);
        }

        int somaDosQuatroPrimeirosPicos = calcularSomaDosQuatroPrimeirosPicos();
        double mediaDosQuatroPrimeirosPicos = calcularMediaDosQuatroPrimeirosPicos();

        infoPicos.put("Soma dos picos", somaDosQuatroPrimeirosPicos);
        infoPicos.put("Média dos picos", mediaDosQuatroPrimeirosPicos);


        return infoPicos;
    }

    public double calcularTempoMedioEntrePicos() {
        List<Integer> temposDosPicos = new ArrayList<>();
        List<Integer> valoresDosPicos = obterValoresDosPicos();

        for (DadoSensor dado : dadosDoSensor) {
            if (valoresDosPicos.contains(dado.getValor())) {
                temposDosPicos.add(dado.getSegundos());
            }
        }

        double somaDosTempos = 0;
        for (int i = 0; i < temposDosPicos.size() - 1; i++) {
            somaDosTempos += Math.abs(temposDosPicos.get(i) - temposDosPicos.get(i + 1));
        }

        int quantidadePicos = temposDosPicos.size();
        double tempoMedioEntrePicos = somaDosTempos / (quantidadePicos - 1);

        return tempoMedioEntrePicos;
    }


    public List<DadoSensor> getDadosDoSensor() {
        return dadosDoSensor;
    }





}