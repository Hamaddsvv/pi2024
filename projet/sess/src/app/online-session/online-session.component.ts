// online-session.component.ts

import { Component, OnInit } from '@angular/core';
import { OnlineSessionService } from '../services/online-session.service';

@Component({
  selector: 'app-online-session',
  templateUrl: './online-session.component.html',
  styleUrls: ['./online-session.component.css']
})
export class OnlineSessionComponent implements OnInit {
  sessions: any[] = [];
  selectedSession: any = { id: null, name: '', startTime: null, endTime: null, description: '' };
  showForm: boolean = false;

  constructor(private onlineSessionService: OnlineSessionService) { }

  ngOnInit(): void {
    this.loadSessions();
  }

  loadSessions(): void {
    this.onlineSessionService.getAllSessions().subscribe(sessions => this.sessions = sessions);
  }

  addSession(): void {
    this.onlineSessionService.addSession(this.selectedSession).subscribe(() => {
      this.selectedSession = { id: null, name: '', startTime: null, endTime: null, description: '' };
      this.loadSessions();
    });
  }

  updateSession(): void {
    this.onlineSessionService.updateSession(this.selectedSession.id, this.selectedSession).subscribe(() => {
      this.selectedSession = { id: null, name: '', startTime: null, endTime: null, description: '' };
      this.loadSessions();
    });
  }

  deleteSession(session: any): void {
    this.onlineSessionService.deleteSession(session.id).subscribe(() => {
      this.loadSessions();
    });
  }

  selectSession(session: any): void {
    this.selectedSession = { ...session };
  }

  showAddForm(): void {
    this.showForm = !this.showForm;
  }
}
