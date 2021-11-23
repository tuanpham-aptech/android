import {Component, OnInit} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {Student} from '../../../models/student';
import {AppService} from '../../../services/app.service';
import {Course} from '../../../models/course';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentAdminComponent implements OnInit {
  init = environment.init;
  newStudent: Student;
  students: Array<Student> = [];
  editStudent: Student;
  courses: Array<Course>;

  constructor(private appService: AppService) {
    this.newStudent = {
      courses: [],
      _id: '',
      createdAt: null,
      role: '',
      updatedAt: null,
      name: '',
      username: '',
      password: '',
      birthday: '',
      class: 0,
      type: 0,
      status: 0,
      editMode: false
    };
  }

  ngOnInit(): void {
    this.listStudents();
    this.listCourses();
  }

  submitAdd() {
    this.appService.postStudent(this.newStudent).subscribe((res: any) => {
      this.listStudents();
      this.newStudent = {
        courses: [],
        _id: '',
        createdAt: null,
        role: '',
        updatedAt: null,
        name: '',
        username: '',
        password: '',
        birthday: '',
        class: 0,
        type: 0,
        status: 0,
        editMode: false
      };
    });
  }

  listStudents() {
    this.appService.listStudent().subscribe((res: any) => {
      if (res && res.success) {
        this.students = res.data;
      }
    });
  }

  getNameById(arrayData, id) {
    const d = arrayData.find(x => x.id === id);
    if (d) {
      return d.name;
    }
    return '';
  }

  submitUpdate() {
    this.appService.updateStudent(this.editStudent).subscribe((res: any) => {
      this.listStudents();
      this.editStudent.editMode = false;
    });
  }

  listCourses() {
    this.appService.listCourses().subscribe((res: any) => {
      if (res && res.success) {
        this.courses = res.data;
      }
    });
  }

  deleteStudent(student: Student) {
    if (confirm('Bạn có muốn xóa học sinh này?')) {
      this.appService.deleteStudent(student).subscribe((res: any) => {
        this.listStudents();
      });
    }
  }
}
