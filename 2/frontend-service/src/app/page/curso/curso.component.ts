import { Component, OnInit } from '@angular/core';
import { ConectarService } from '../../services/conectar.service';
import { Curso, Compra } from '../../model/usuario';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrls: ['./curso.component.css']
})
export class CursoComponent implements OnInit {

  // tslint:disable-next-line: new-parens
  curso = new Curso();
  cursos: Curso[];
  compra = new Compra();
  show1 = true;
  show2 = false;
  show3 = false;

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
      this.listar();
    });
    f.reset();
    this.show1 = false;
    this.show2 = true;
  }

  agregar(curso: any) {
    console.log(curso);
  }

  onSubmit2(f: NgForm) {
    console.log(f);
    this.save(this.compra, f);
  }

  save(comp: Compra, f: NgForm) {
    this.servicio.saveCompra(comp).subscribe(data => {
      console.log('OK');
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
