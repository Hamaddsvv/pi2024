// online-session.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OnlineSessionService {
  private apiUrl = 'http://localhost:8081/exam/online-sessions';

  constructor(private http: HttpClient) { }

  getAllSessions(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/getAll`);
  }

  getSessionById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get/${id}`);
  }

  addSession(session: any): Observable<any> {
    // Convertir la date en string avant de l'envoyer au serveur
    session.startTime = new Date(session.startTime).toLocaleString();
    session.endTime = new Date(session.endTime).toLocaleString();
    
    return this.http.post<any>(`${this.apiUrl}/add`, session);
  }

  updateSession(id: number, session: any): Observable<any> {
    // Convertir la date en string avant de l'envoyer au serveur
    session.startTime = new Date(session.startTime).toLocaleString();
    session.endTime = new Date(session.endTime).toLocaleString();

    return this.http.put<any>(`${this.apiUrl}/put/${id}`, session);
  }

  deleteSession(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete/${id}`);
  }
}
