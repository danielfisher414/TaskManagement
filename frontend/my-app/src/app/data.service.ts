import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getData(): Observable<any> {
    return this.http.get('http://localhost:8080/all');
  }

  postNote(note: any): Observable<any> {
    return this.http.post('http://localhost:8080/create', note);
  }
}
