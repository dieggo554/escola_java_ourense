import { Component, OnInit } from '@angular/core';
import { CuentaBanc } from '../modelo/CuentaBanc';
import { CuentasRestService } from '../cuentas-rest.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-nueva-cuenta',
  templateUrl: './nueva-cuenta.component.html',
  styleUrls: ['./nueva-cuenta.component.css']
})
export class NuevaCuentaComponent implements OnInit {

  cuenta: CuentaBanc;
  recibido: boolean;

  // Angular detecta que el componente necesita el servicio,
  // así que le inyecta el único que ha creado
  // Como el @Autowired de Spring, es la inyección de dependencias
  constructor(private srvCuentasRest: CuentasRestService) { }

  ngOnInit() {
    this.cuenta = new CuentaBanc(0, "", "");
  }
  crearCuenta(): void {
    let observador: Observable<CuentaBanc>;
    observador = this.srvCuentasRest.add(this.cuenta);
    observador.subscribe((objNoSexual) => {
      console.log("Datos: " + objNoSexual["iban"]);
      this.recibido = true;
    });

    console.log(this.cuenta.toString());
  }
}
