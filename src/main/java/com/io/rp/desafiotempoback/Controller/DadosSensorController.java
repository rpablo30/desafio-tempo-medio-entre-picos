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

        infoPicos.put("Soma dos picos", somaDosQuatroPrimeirosPicos);
        infoPicos.put("Média dos picos", mediaDosQuatroPrimeirosPicos);
        infoPicos.put("Tempo médio entre os picos", String.format("%02d.%02d", (int)(tempoMedioEntrePicos / 60), (int)(tempoMedioEntrePicos % 60)));

        List<Integer> diferencaDeTempoEntrePicos = dadoSensorService.calcularDiferencasDeTempoEntrePicos();
        for (int i = 0; i < diferencaDeTempoEntrePicos.size(); i++) {
            int difTemp = diferencaDeTempoEntrePicos.get(i);
            infoPicos.put("difTempPico" + (i + 1) + "Pico" + (i + 2), String.format("%02d.%02d", (int)(difTemp / 60), (int)(difTemp % 60)));
        }

        return ResponseEntity.ok(infoPicos);
    }
}

