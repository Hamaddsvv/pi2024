// task-session.component.ts

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskSessionService } from '../services/task-session.service';

@Component({
  selector: 'app-task-session',
  templateUrl: './task-session.component.html',
  styleUrls: ['./task-session.component.css']
})
export class TaskSessionComponent implements OnInit {
  taskId?: number; // Utilisation du signe d'interrogation

  constructor(private route: ActivatedRoute, private taskSessionService: TaskSessionService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.taskId = +params['id'];
    });
  }

  startTaskSession(): void {
    if (this.taskId !== undefined) {
      this.taskSessionService.startTaskSession(this.taskId).subscribe(response => {
        // Traiter la réponse du backend, par exemple, rediriger vers la page de la session
      });
    }
  }
}
