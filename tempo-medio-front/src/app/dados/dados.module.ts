import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { MoneyPipe } from '../shared/pipe/number-formater';
import { SharedModule } from '../shared/shared.module';
import { CanvasJSAngularChartsModule } from '@canvasjs/angular-charts';
import { DadostempoComponent } from './dadostempo/dadostempo.component';
import { DadosRoutingModule } from './dados-routing.module';


@NgModule({
  declarations: [
    MoneyPipe,
    DadostempoComponent,

  ],
  imports: [
    CommonModule,
    DadosRoutingModule,
    AppMaterialModule,
    SharedModule,
    CanvasJSAngularChartsModule
  ]
})
export class DadostempoModule { }
