import {Component, OnInit} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {Course} from '../../../models/course';
import {AppService} from '../../../services/app.service';
import {Video} from '../../../models/video';
import {Student} from '../../../models/student';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseAdminComponent implements OnInit {
  courses: Array<Course> = [];
  newCourse: Course;
  selectedCourse: Course;
  init = environment.init;
  videos: Array<Video> = [];
  modalAddVideo = false;
  selectedVideoIds = [];


  constructor(private appService: AppService) {
    this.newCourse = {
      editMode: false,
      _id: '', videoIds: [], viewVideos: false, class: 0, createdAt: null, name: '', subject: 0, type: 0, updatedAt: null
    };
  }

  ngOnInit(): void {
    this.listVideos();
    this.listCourses();
  }

  getNameById(id, arrayData) {
    const d = arrayData.find(x => x.id === id);
    if (d) {
      return d.name;
    }
    return '';
  }

  submitAdd() {
    this.appService.postCourse(this.newCourse).subscribe((res: any) => {
      if (res && res.success) {
        this.listCourses();
        this.newCourse = {
          editMode: false,
          _id: '',
          videoIds: [],
          viewVideos: false,
          class: 0,
          createdAt: null,
          name: '',
          subject: 0,
          type: 0,
          updatedAt: null
        };
      }
    });
  }

  listCourses() {
    this.appService.listCourses().subscribe((res: any) => {
      if (res && res.success) {
        this.courses = res.data;
      }
    });
  }

  listVideos() {
    this.appService.listVideos().subscribe((res: any) => {
      if (res && res.success) {
        this.videos = res.data;
      }
    });
  }

  hasSelectedVideo(id) {
    return !!this.selectedVideoIds.find(x => x === id);
  }

  openModalAddVideo(course: Course) {
    this.selectedCourse = course;
    this.selectedVideoIds = JSON.parse(JSON.stringify(course.videoIds));
    this.modalAddVideo = true;
  }

  addVideoToSelected(video: Video) {
    this.selectedVideoIds.push(video._id);
  }

  removeVideoToSelected(video: Video) {
    this.selectedVideoIds = this.selectedVideoIds.filter(x => x !== video._id);
  }

  submitUpdateSelectedVideos() {
    this.selectedCourse.videoIds = this.selectedVideoIds;
    this.modalAddVideo = false;

    this.appService.updateCourse(this.selectedCourse).subscribe((res: any) => {
      if (res && res.success) {
        this.listCourses();
      }
    });
  }

  deleteCourse(course: Course) {
    if (confirm('Bạn có muốn xóa khóa học này?')) {
      this.appService.deleteCourse(course._id).subscribe((res: any) => {
        this.listCourses();
      });
    }
  }

  async submitUpdate(course: Course) {
    const result = await this.appService.updateCourse(course).toPromise();
    this.listCourses();
  }
}
