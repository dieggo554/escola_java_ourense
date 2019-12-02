import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCuentasComponent } from './lista-cuentas.component';

describe('ListaCuentasComponent', () => {
  let component: ListaCuentasComponent;
  let fixture: ComponentFixture<ListaCuentasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaCuentasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaCuentasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
