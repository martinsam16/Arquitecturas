import { Injectable } from '@angular/core';
import { Categoria } from '../categoria';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriaSService {

  private catsUrl: string;

  constructor(private http: HttpClient) {
    this.catsUrl = 'http://localhost:8081/api/categoria';
  }

  public findAll(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.catsUrl);
  }

  public save(cat: Categoria) {
    return this.http.post<Categoria>(this.catsUrl, cat);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.catsUrl}/${id}`);
  }
}
