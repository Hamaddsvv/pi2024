// src/app/services/poker-card.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PokerCardService {
  private apiUrl = 'http://localhost:8081/exam/pokercards';

  constructor(private http: HttpClient) { }

  getAllCards(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/getAll`);
  }

  getCardById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get/${id}`);
  }

  addCard(card: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add`, card);
  }

  updateCard(id: number, card: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/put/${id}`, card);
  }

  deleteCard(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete/${id}`);
  }
}
