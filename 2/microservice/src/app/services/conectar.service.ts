import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Curso, Usuario, Compra, Venta } from '../model/usuario';
import { constants } from 'buffer';

@Injectable({
  providedIn: 'root'
})
export class ConectarService {

  api = environment.apiconx;

  constructor(private http: HttpClient) { }

  // Listar cursos
  public listCurso() {
    return this.http.get<Curso[]>(`${this.api}/curso`);
  }

  // Listar usuarios
  public listUsers() {
    return this.http.get<Usuario[]>(`${this.api}/usuario`);
  }

  // Listar compras por usuario
  public listVenta() {
    return this.http.get<Venta[]>(`${this.api}/usuario_curso`);
  }

  // Listar compras por usuario
  public saveCompra(compra: Compra) {
    return this.http.post<Compra[]>(`${this.api}/curso/comprar`, compra);
  }

  // Guardar curso
  public saveCurso(curso: Curso) {
    return this.http.post<Curso>(`${this.api}/curso`, curso);
  }

}
