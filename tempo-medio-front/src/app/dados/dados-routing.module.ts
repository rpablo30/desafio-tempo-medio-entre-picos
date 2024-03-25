import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DadostempoComponent } from './dadostempo/dadostempo.component';



const routes: Routes = [
  { path: '', component: DadostempoComponent },
  { path: 'mes', component: DadostempoComponent },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DadosRoutingModule { }
