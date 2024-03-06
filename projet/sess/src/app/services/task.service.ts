// task.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private apiUrl = 'http://localhost:8081/exam/tasks';

  constructor(private http: HttpClient) {}

  getAllTasks(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/getAll`);
  }

  addTask(task: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add`, task);
  }

  updateTask(id: number, task: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/put/${id}`, task);
  }

  deleteTask(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete/${id}`);
  }
}
