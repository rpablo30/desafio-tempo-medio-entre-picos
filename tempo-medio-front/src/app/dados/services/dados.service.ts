import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, delay, first, tap } from 'rxjs';
import { DadosTempoModel } from '../model/dadosTempoModel';


@Injectable({
  providedIn: 'root'
})
export class DadosService {

  private readonly API = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) {}

  getDadosTempo(): Observable<DadosTempoModel[]> {
    return this.httpClient.get<DadosTempoModel[]>(`${this.API}/tempo-medio-entre-picos`)
      .pipe(
        tap(dados => console.log('Dados recebidos do backend:', dados))
      );
  }
  encontrarPicosVerdadeiros(dados: DadosTempoModel[]): number[] {
    return [];
  }



  getValoresDosPicos(): Observable<number[]> {
    return this.httpClient.get<number[]>(`${this.API}/valores-de-pico`)
      .pipe(
        tap(valores => console.log('Valores de pico recebidos do backend:', valores))
      );
  }

  obterInfoDosPicos(): Observable<any> {
    return this.httpClient.get<any>(`${this.API}/todosPicos`);
  }




}
