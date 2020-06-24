import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CursoComponent } from './page/curso/curso.component';
import { UsuarioComponent } from './page/usuario/usuario.component';


const routes: Routes = [
  {path: 'cursos', component: CursoComponent},
  {path: 'usuario', component: UsuarioComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const APP_ROUTING = RouterModule.forRoot(routes, {useHash: true});

