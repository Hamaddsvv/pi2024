import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  isCardOptionsVisible: boolean = false;
  isOnlineSessionOptionsVisible: boolean = false;

  constructor(private router: Router) { }

  toggleCardOptions(): void {
    this.isCardOptionsVisible = !this.isCardOptionsVisible;
    // Make sure to reset other options if necessary
    this.isOnlineSessionOptionsVisible = false;
  }

  toggleOnlineSessionOptions(): void {
    this.isOnlineSessionOptionsVisible = !this.isOnlineSessionOptionsVisible;
    // Make sure to reset other options if necessary
    this.isCardOptionsVisible = false;
  }

  navigateToTasks(): void {
    this.router.navigate(['/tasks']);
  }
}
