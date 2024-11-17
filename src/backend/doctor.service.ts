import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private apiUrl = 'http://localhost:3000/api/doctors';  // URL de tu API backend

  constructor(private http: HttpClient) {}

  // Método para obtener la lista de doctores desde el backend
  getDoctors(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
