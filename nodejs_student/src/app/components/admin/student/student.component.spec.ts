import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentAdminComponent } from './student.component';

describe('StudentComponent', () => {
  let component: StudentAdminComponent;
  let fixture: ComponentFixture<StudentAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
