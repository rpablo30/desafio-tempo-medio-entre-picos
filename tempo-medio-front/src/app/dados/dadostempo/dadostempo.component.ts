import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DadosTempoModel } from '../model/dadosTempoModel';
import { DadosService } from '../services/dados.service';

@Component({
  selector: 'app-dadostempo',
  templateUrl: './dadostempo.component.html',
  styleUrls: ['./dadostempo.component.scss']
})
export class DadostempoComponent implements OnInit {
  dadostempo: DadosTempoModel[] = [];
  tempoMedio: string = '';
  diferencasTempo: number[] = [];
  chartOptions: any = [];
  valoresPicos: number[] = [];
  infoPicos: any = {};
  picos: string[] = [];

  info: any;
  somaDosPicos: number = 0;
  mediaDosPicos: number = 0;
  difTempPico1Pico2: number = 0;
  difTempPico2Pico3: number = 0;
  difTempPico3Pico4: number = 0;
  tempoMedioEntrePicos: number = 0;

  constructor(
    private dadosTempoService: DadosService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.dadosTempoService.getDadosTempo().subscribe(dadostempo => {
      this.dadostempo = dadostempo;
      const picos = this.dadosTempoService.encontrarPicosVerdadeiros(dadostempo);
      this.diferencasTempo = this.calcularDiferencasTempo(picos);
      this.tempoMedio = this.calcularTempoMedio(this.diferencasTempo);
      this.chartOptions = this.generateChartOptions(dadostempo);
    });

    this.dadosTempoService.getValoresDosPicos().subscribe(valores => {
      this.valoresPicos = valores;
    });

    this.dadosTempoService.obterInfoDosPicos().subscribe(info => {
      this.infoPicos = info;
      this.picos = Object.keys(info).filter(key => key.includes('Pico'));
      this.somaDosPicos = this.infoPicos['Soma dos picos'];
      this.mediaDosPicos = this.infoPicos['Média dos picos'];
      this.difTempPico1Pico2 = this.infoPicos['difTempPico1Pico2'];
      this.difTempPico2Pico3 = this.infoPicos['difTempPico2Pico3'];
      this.difTempPico3Pico4 = this.infoPicos['difTempPico3Pico4'];
      this.tempoMedioEntrePicos = this.infoPicos['Tempo médio entre os picos'];
    });




  }


  calcularDiferencasTempo(picos: number[]): number[] {
    const diferencasTempo: number[] = [];
    for (let i = 1; i < picos.length; i++) {
      diferencasTempo.push(picos[i] - picos[i - 1]);
    }
    return diferencasTempo;
  }

  calcularTempoMedio(diferencasTempo: number[]): string {
    if (diferencasTempo.length === 0) {
      return 'N/A';
    }

    const tempoMedio = diferencasTempo.reduce((acc: number, curr: number) => acc + curr, 0) / diferencasTempo.length;
    const minutos = Math.floor(tempoMedio / 60);
    const segundos = Math.floor(tempoMedio % 60);

    return `${minutos}:${segundos < 10 ? '0' : ''}${segundos}`;
  }

  onError(errorMsg: string): void {
    console.error(errorMsg);
  }

  private generateChartOptions(data: DadosTempoModel[]): any {
    const dataPoints = data.map(item => ({
      x: item.segundos,
      y: item.valor,
      markerType: this.getMarkerType(item.valor),
      markerSize: this.getMarkerSize(item.valor),
      markerColor: this.getMarkerColor(item.valor)
    }));

    return {
      animationEnabled: true,
      animationDuration: 2000,
      title: {
        text: "Dados tempos de pico"
      },
      toolTip: {
        shared: true
      },
      axisY: {
        title: "Valor",
        includeZero: false,
        interval: 20,
        minimum: 0,
        maximum: 80
      },
      axisX: {
        titleFontColor: "#000",
        titleFontFamily: "Arial",
        titleFontSize: 16,
        labelAngle: 0,
        labelFontColor: "#000",
        labelFontFamily: "Arial",
        labelFontSize: 12,
        interval: 10,
        minimum: 0,
        maximum: 70
      },
      data: [{
        type: "line",
        markerSize: 0,
        dataPoints: dataPoints
      }]
    };
  }

  private getMarkerType(valor: number): string {
    if (valor > 60) {
      return 'circle';
    } else if (valor >= 52 && valor <= 60) {
      return 'circle';
    } else {
      return 'none';
    }
  }

  private getMarkerSize(valor: number): number {
    return valor > 60 || (valor >= 40 && valor <= 60) ? 8 : 0;
  }

  private getMarkerColor(valor: number): string {
    return valor > 60 ? 'red' : (valor >= 40 && valor <= 60) ? 'blue' : 'none';
  }
}
