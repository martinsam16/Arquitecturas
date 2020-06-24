import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CatListComponent } from './cat-list/cat-list.component';
import { CatFormComponent } from './cat-form/cat-form.component';
import { HttpClientModule } from '@angular/common/http';
import { CategoriaSService } from './service/categoria-s.service';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'view', component: CatListComponent },
  { path: 'regst', component: CatFormComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    CatListComponent,
    CatFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
  ],
  providers: [CategoriaSService],
  bootstrap: [AppComponent]
})
export class AppModule { }
