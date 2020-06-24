import { Component, OnInit } from '@angular/core';
import { ConectarService } from '../../services/conectar.service';
import { Curso, Compra } from '../../model/usuario';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrls: ['./curso.component.css']
})
export class CursoComponent implements OnInit {

  // tslint:disable-next-line: new-parens
  curso = new Curso();
  cursos: Curso[];
  email: string;
  libro = {};
  libros = [];
  show1 = true;
  show2 = false;
  show3 = false;
  alert2 = false;

  constructor(private servicio: ConectarService) { }

  ngOnInit(): void {
  }

  listar() {
    this.servicio.listCurso().subscribe(data => {
      this.cursos = data;
    });
  }

  onSubmit(f: NgForm) {
    this.enviar(this.curso, f);
  }

  enviar(body: Curso, f: NgForm) {
    this.servicio.saveCurso(body).subscribe(data => {
      this.listar(); }, (error: any) => {
      if (error instanceof HttpErrorResponse) {
        if (error.status === 400) {
          this.alert2 = false;
        }
        if (error.status === 500) {
          this.alert2 = false;
        }
      }
    });
    f.reset();
    this.show1 = false;
    this.show2 = true;
  }

  agrega(curso: string) {
    this.libros.push(this.libro = {_id: curso});
    console.log(this.libros);
  }

  onSubmit2(f: NgForm) {
    const compra = {
      email: this.email,
      cursosComprar: this.libros
    };
    this.save(compra, f);
  }

  save(comp: any, f: NgForm) {
    this.servicio.saveCompra(comp).subscribe(data => {
        console.log('ok'); }, (error: any) => {
        if (error instanceof HttpErrorResponse) {
          if (error.status === 400) {
            this.alert2 = false;
          }
          if (error.status === 500) {
            this.alert2 = false;
          }
        }
      });
    f.reset();
  }

  ver(tipo: string) {
    if (tipo === 'R') {
      this.show1 = true;
      this.show2 = false;
      this.show3 = false;
    }
    if (tipo === 'L') {
      this.show2 = true;
      this.show1 = false;
      this.show3 = false;
      this.listar();
    }
    if (tipo === 'A') {
      this.show3 = true;
      this.show2 = false;
      this.show1 = false;
      this.listar();
    }
  }

}
