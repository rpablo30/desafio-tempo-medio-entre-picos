import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DadostempoComponent } from './dadostempo.component';



describe('DespesasPorMesComponent', () => {
  let component: DadostempoComponent;
  let fixture: ComponentFixture<DadostempoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DadostempoComponent]
    });
    fixture = TestBed.createComponent(DadostempoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
