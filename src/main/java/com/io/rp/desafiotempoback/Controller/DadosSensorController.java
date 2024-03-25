package com.io.rp.desafiotempoback.Controller;


import com.io.rp.desafiotempoback.Entity.DadoSensor;
import com.io.rp.desafiotempoback.Service.DadoSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DadosSensorController {

    @Autowired
    private DadoSensorService dadoSensorService;

    @GetMapping("/tempo-medio-entre-picos")
    public List<Map<String, Integer>> obterPontosDoGrafico() {
        return dadoSensorService.obterPontosDoGrafico();
    }

    @GetMapping("/valores-de-pico")
    public ResponseEntity<List<Integer>> obterValoresDosPicos() {
        List<Integer> valoresDosPicos = dadoSensorService.obterValoresDosPicos();
        return ResponseEntity.ok(valoresDosPicos);
    }

    @GetMapping("/todosPicos")
    public ResponseEntity<Map<String, Object>> tempoMedioEntrePicos() {
        Map<String, Object> infoPicos = dadoSensorService.obterInfoDosPicos();

        if (infoPicos.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        double tempoMedioEntrePicos = dadoSensorService.calcularTempoMedioEntrePicos();
        int somaDosQuatroPrimeirosPicos = dadoSensorService.calcularSomaDosQuatroPrimeirosPicos();
        double mediaDosQuatroPrimeirosPicos = dadoSensorService.calcularMediaDosQuatroPrimeirosPicos();

        infoPicos.put("Tempo médio entre os picos", tempoMedioEntrePicos);
        infoPicos.put("Soma dos picos", somaDosQuatroPrimeirosPicos);
        infoPicos.put("Média dos picos", mediaDosQuatroPrimeirosPicos);

        List<Integer> temposDosPicos = new ArrayList<>();
        List<Integer> valoresDosPicos = dadoSensorService.obterValoresDosPicos();

        for (DadoSensor dado : dadoSensorService.getDadosDoSensor()) {
            if (valoresDosPicos.contains(dado.getValor())) {
                temposDosPicos.add(dado.getSegundos());
            }
        }

        List<Integer> diferencaDeTemposEntrePicos = new ArrayList<>();
        for (int i = 0; i < temposDosPicos.size() - 1; i++) {
            diferencaDeTemposEntrePicos.add(Math.abs(temposDosPicos.get(i) - temposDosPicos.get(i + 1)));
        }

        infoPicos.put("Diferença de tempo entre os picos", diferencaDeTemposEntrePicos);

        return ResponseEntity.ok(infoPicos);
    }

}

