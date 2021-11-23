import {Injectable, EventEmitter} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Student} from '../models/student';
import {Video} from '../models/video';
import {Course} from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  public authEvent = new EventEmitter();

  constructor(private http: HttpClient) {
  }

  getHeaders() {
    if (environment.user) {
      return {
        Token: environment.user.accessToken,
        Uid: environment.user._id,
      };
    } else {
      return {};
    }
  }

  init() {
    return this.http.get(environment.hostApi + '/init');
  }

  login(username, password): Observable<any> {
    return this.http.post(environment.hostApi + '/login', {username, password});
  }

  postStudent(student: Student) {
    return this.http.post(environment.hostAdmin + '/student', student, {
      headers: this.getHeaders()
    });
  }

  listStudent() {
    return this.http.get(environment.hostAdmin + '/student', {
      headers: this.getHeaders()
    });
  }

  updateStudent(student: Student) {
    return this.http.put(environment.hostAdmin + '/student/' + student._id, student, {
      headers: this.getHeaders()
    });
  }

  deleteStudent(student: Student) {
    return this.http.delete(environment.hostAdmin + '/student/' + student._id, {
      headers: this.getHeaders()
    });
  }

  postVideo(video: Video) {
    return this.http.post(environment.hostAdmin + '/video', video, {
      headers: this.getHeaders()
    });
  }

  listVideos() {
    return this.http.get(environment.hostAdmin + '/video', {
      headers: this.getHeaders()
    });
  }

  deleteVideos(id) {
    return this.http.delete(environment.hostAdmin + '/video/' + id, {
      headers: this.getHeaders()
    });
  }

  updateVideo(video: Video) {
    return this.http.put(environment.hostAdmin + '/video/' + video._id, video, {
      headers: this.getHeaders()
    });
  }

  postCourse(course: Course) {
    return this.http.post(environment.hostAdmin + '/course', course, {
      headers: this.getHeaders()
    });
  }

  listCourses() {
    return this.http.get(environment.hostAdmin + '/course', {
      headers: this.getHeaders()
    });
  }

  updateCourse(course: Course) {
    return this.http.put(environment.hostAdmin + '/course/' + course._id, course, {
      headers: this.getHeaders()
    });
  }

  deleteCourse(id) {
    return this.http.delete(environment.hostAdmin + '/course/' + id, {
      headers: this.getHeaders()
    });
  }


  listStudentVideos() {
    return this.http.get(environment.hostStudent + '/videos', {
      headers: this.getHeaders()
    });
  }

  getVideoUrl(videoId) {
    return this.http.get(environment.hostStudent + '/video/' + videoId, {
      headers: this.getHeaders()
    });
  }
}
