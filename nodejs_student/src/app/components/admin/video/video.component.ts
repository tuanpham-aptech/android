import {Component, OnInit} from '@angular/core';
import {Video} from '../../../models/video';
import {environment} from '../../../../environments/environment';
import {AppService} from '../../../services/app.service';
import {Student} from '../../../models/student';

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.css']
})
export class VideoAdminComponent implements OnInit {
  newVideo: Video;
  init = environment.init;
  videos: Array<Video> = [];

  constructor(private appService: AppService) {
    this.newVideo = {
      editMode: false,
      _id: '',
      class: 0,
      createdAt: null,
      idVideo: '',
      name: '',
      subject: 0,
      thumbnailUrl: '',
      type: 0,
      updatedAt: null,
      url: ''
    };
  }

  globalEditMode = false;

  ngOnInit(): void {
    this.listVideos();
  }

  submitAdd() {
    this.appService.postVideo(this.newVideo).subscribe((res: any) => {
      if (res && res.success) {
        this.listVideos();
        this.newVideo = {
          editMode: false,
          _id: '',
          class: 0,
          createdAt: null,
          idVideo: '',
          name: '',
          subject: 0,
          thumbnailUrl: '',
          type: 0,
          updatedAt: null,
          url: ''
        };
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

  getNameById(id, arrayData) {
    const d = arrayData.find(x => x.id === id);
    if (d) {
      return d.name;
    }
    return '';
  }

  deleteVideo(video: Video) {
    if (confirm('Bạn có muốn xóa video này?')) {
      this.appService.deleteVideos(video._id).subscribe((res: any) => {
        this.listVideos();
      });
    }
  }

  async submitUpdate(video: Video) {
    const result = await this.appService.updateVideo(video).toPromise();
    this.listVideos();
  }
}

