import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseAdminComponent } from './course.component';

describe('CourseAdminComponent', () => {
  let component: CourseAdminComponent;
  let fixture: ComponentFixture<CourseAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
