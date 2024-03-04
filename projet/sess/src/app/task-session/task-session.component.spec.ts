import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskSessionComponent } from './task-session.component';

describe('TaskSessionComponent', () => {
  let component: TaskSessionComponent;
  let fixture: ComponentFixture<TaskSessionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaskSessionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskSessionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
