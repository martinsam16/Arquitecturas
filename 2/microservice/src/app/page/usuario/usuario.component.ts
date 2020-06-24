import { Component, OnInit } from '@angular/core';
import { ConectarService } from '../../services/conectar.service';
import { Venta } from '../../model/usuario';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  usuarios: Venta[];

  constructor(private servicio: ConectarService) {
    this.listVentas();
  }

  ngOnInit(): void {
  }

  listVentas() {
    this.servicio.listVenta().subscribe(data => {
      this.usuarios = data;
      console.log(this.usuarios);
    });
  }

}
