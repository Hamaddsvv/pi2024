// src/app/app-routing.module.ts

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CardListComponent } from './card-list/card-list.component';
import { OnlineSessionComponent } from './online-session/online-session.component';
import { TaskComponent } from './task/task.component';
import { TaskSessionComponent } from './task-session/task-session.component';
const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'card-list', component: CardListComponent },
  { path: 'online-session', component: OnlineSessionComponent },
  { path: 'tasks', component: TaskComponent },
  { path: 'task-session/:id', component: TaskSessionComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
