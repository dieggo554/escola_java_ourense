import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { CuentaBanc } from './modelo/CuentaBanc';

// Objeto que angular se encarga de instanciar como un Singleton
@Injectable({
  providedIn: 'root'
})
export class CuentasRestService {

  // Infiere el tipo a partir del valor ("" es String)
  urlApiRest = "http://localhost:8080/cuentas";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private httpCli: HttpClient) { }

  public add(nuevaCuenta: CuentaBanc): Observable<CuentaBanc> {
    return this.httpCli.post<CuentaBanc>(this.urlApiRest, nuevaCuenta, this.httpOptions);
  }

  public traerTodos(): Observable<CuentaBanc[]> {
    return this.httpCli.get<CuentaBanc[]>(this.urlApiRest);
  }

  public modificar(id: Number, nuevaCuenta: CuentaBanc): Observable<CuentaBanc> {
    return this.httpCli.put<CuentaBanc>(this.urlApiRest + "/" + id, nuevaCuenta, this.httpOptions);
  }

  public eliminar(id: Number): Observable<void> {
    return this.httpCli.delete<void>(this.urlApiRest + "/" + id);
  }
}
