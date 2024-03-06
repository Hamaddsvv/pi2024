// task.component.ts

import { Component, OnInit } from '@angular/core';
import { TaskSessionService } from '../services/task-session.service';
import { TaskService } from '../services/task.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  tasks: any[] = [];

  constructor(private taskService: TaskService, private taskSessionService: TaskSessionService) { }

  ngOnInit(): void {
    this.loadTasks();
  }

  loadTasks(): void {
    this.taskService.getAllTasks().subscribe((tasks: any[]) => {
      this.tasks = tasks;
    });
  }

  startTaskSession(task: any): void {
    this.taskSessionService.startTaskSession(task.id).subscribe(response => {
      // Traiter la réponse du backend, par exemple, rediriger vers la page de la session
      // Vous pouvez également mettre à jour l'interface utilisateur si nécessaire
    });
  }
}
