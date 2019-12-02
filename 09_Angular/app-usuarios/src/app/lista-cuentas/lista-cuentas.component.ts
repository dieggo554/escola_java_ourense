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
  cuentaEditar: CuentaBanc = null;

  constructor(private srvCuentas : CuentasRestService) { 
    this.srvCuentas.alCambiar = () => {
      this.ngOnInit();
    };
  }

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

  modificarCuenta(id: Number, cuenta: CuentaBanc): void {
    this.srvCuentas.modificar(id, cuenta, (datos) => {
      console.log("Modificado "  + datos.toString());
      this.cuentaEditar = null;
    });
  }

  eliminarCuenta(id: Number): void {
    this.srvCuentas.eliminar(id);
  }
}
