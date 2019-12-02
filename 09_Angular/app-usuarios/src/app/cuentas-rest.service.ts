import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { CuentaBanc } from './modelo/CuentaBanc';

// Objeto que angular se encarga de instanciar como un Singleton
@Injectable({
  providedIn: 'root'
})
export class CuentasRestService {

  alCambiar: any;

  // Infiere el tipo a partir del valor ("" es String)
  urlApiRest = "http://localhost:8080/cuentas";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private httpCli: HttpClient) { }

  public add(nuevaCuenta: CuentaBanc, lambda: any): Observable<CuentaBanc> {
    let observable: Observable<CuentaBanc> = this.httpCli.post<CuentaBanc>(this.urlApiRest,
      nuevaCuenta, this.httpOptions);
      observable.subscribe((datos) => { // Datos de la cuanta con el ID
        this.alCambiar(datos);          // Probablemente actualiza la lista
        lambda(datos);                  // Invoca a la suscripcion del componente nuevo
      });
    return observable;
  }

  public traerTodos(): Observable<CuentaBanc[]> {
    return this.httpCli.get<CuentaBanc[]>(this.urlApiRest);
  }

  public modificar(id: Number, nuevaCuenta: CuentaBanc, lambda: any): Observable<CuentaBanc> {
    let observable: Observable<CuentaBanc> = this.httpCli.put<CuentaBanc>(this.urlApiRest  + "/" + id,
      nuevaCuenta, this.httpOptions);
      observable.subscribe((datos) => { // Datos de la cuanta con el ID
        this.alCambiar(datos);          // Probablemente actualiza la lista
        lambda(datos);                  // Invoca a la suscripcion del componente nuevo
      });
    return observable;
  }

  public eliminar(id: Number) {
    this.httpCli.delete<void>(this.urlApiRest + "/" + id, this.httpOptions).subscribe(
      (datos) => {
        this.alCambiar(datos); 
        console.log("Eliminado " + id);
      });
  }
}
