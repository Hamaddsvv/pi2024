// app.module.ts

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatListModule } from '@angular/material/list';
import { CardListComponent } from './card-list/card-list.component';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { OnlineSessionComponent } from './online-session/online-session.component';
import { MatDatepickerModule } from '@angular/material/datepicker';


import { MatNativeDateModule } from '@angular/material/core';
import { TaskComponent } from './task/task.component';
import { TaskSessionComponent } from './task-session/task-session.component';
@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    CardListComponent,
    OnlineSessionComponent,
    TaskComponent,
    TaskSessionComponent,
    
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    MatMenuModule,
    MatListModule,
    MatIconModule,
    CommonModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    BrowserAnimationsModule
  ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
