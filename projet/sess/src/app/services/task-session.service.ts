import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';  // Ajout de HttpErrorResponse
import { Observable, throwError } from 'rxjs';  // Ajout de throwError
import { catchError } from 'rxjs/operators';  // Ajout de catchError

@Injectable({
  providedIn: 'root'
})
export class TaskSessionService {
  private baseUrl = 'http://localhost:8080/task-sessions';

  constructor(private http: HttpClient) { }

  startTaskSession(taskId: number): Observable<any> {
    return this.http.post(`http://localhost:8080/task-sessions/start/${taskId}`, {})
        .pipe(
            catchError((error: HttpErrorResponse) => {
                console.error(error);
                return throwError('Une erreur s\'est produite lors de la demande.');
            })
        );
  }
}
