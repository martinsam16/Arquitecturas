import { Component, OnInit } from '@angular/core';
import { Categoria } from '../categoria';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoriaSService } from '../service/categoria-s.service';

@Component({
  selector: 'app-cat-form',
  templateUrl: './cat-form.component.html',
  styleUrls: ['./cat-form.component.css']
})
export class CatFormComponent {

  catg: Categoria;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private catgService: CategoriaSService) {
    this.catg = new Categoria();
  }

  onSubmit() {
    this.catgService.save(this.catg).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/view']);
  }

}
