import { Component, OnInit } from '@angular/core';
import { CuentaBanc } from '../modelo/CuentaBanc';
import { CuentasRestService } from '../cuentas-rest.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-lista-cuentas',
  templateUrl: './lista-cuentas.component.html',
  styleUrls: ['./lista-cuentas.component.css']
})
export class ListaCuentasComponent implements OnInit {

  arrayCuentas: CuentaBanc[];

  constructor(private srvCuentas: CuentasRestService) { }

  ngOnInit() {
    this.srvCuentas.traerTodos().subscribe((cuentasTraidas: CuentaBanc[]) => {
      this.arrayCuentas = cuentasTraidas;
      console.log("Respuesta AJAX: " + cuentasTraidas.toString());
    });
    console.log(">>> Llamada asincrona AJAX realizada");
  }

  // No funciona por el contexto  
  //  private cuandoRecibeDatos(cuentasTraidas: CuentaBanc[]) {
  //    this.arrayCuentas = cuentasTraidas;
  //    console.log("Respuesta AJAX: " + this.arrayCuentas.toString());
  //  }

  eliminarCuenta(id: Number): void {
    let observador: Observable<void>;
    observador = this.srvCuentas.eliminar(id);
    observador.subscribe(() => {
      console.log("eliminarCuenta realizada");
    });
  }
}
