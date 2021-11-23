import {Component, OnInit} from '@angular/core';
import {AppService} from '../../services/app.service';
import {Video} from '../../models/video';
import {environment} from '../../../environments/environment';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  courses: Array<{
    id: string,
    name: string,
    videos: Array<Video>
  }>;
  playingVideo: any;
  subjects: Array<any> = environment.init.subjects;
  classes: Array<any> = environment.init.classes;
  youtubeSources = [{
    src: 'https://youtube.com/watch?v=bTqVqk7FSmY?modestbranding=1&showinfo=0',
    provider: 'youtube',
  }];
  private subjectId: any = null;
  playOptions = {
    autoplay: true,
    youtube: {
      noCookie: false,
      rel: 0,
      showinfo: 0,
      iv_load_policy: 3,
      modestbranding: 1,
      controls: 0,
      autoplay: 1
    }
  };

  constructor(private appService: AppService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.subjectId = params.id;
      this.listVideos();
    });
  }

  listVideos() {
    this.appService.listStudentVideos().subscribe((res: any) => {
      if (res && res.success) {
        this.courses = res.data;
        if (!!this.subjectId) {
          this.courses = this.courses.filter((x: any) => x.subject.toString() === this.subjectId.toString());
        }
        this.initPlayVideo();
      }
    });
  }

  getNameById(id, arr) {
    const find = arr.find(x => x.id === id);
    return find ? find.name : '';
  }

  initPlayVideo() {
    if (this.courses && this.courses.length > 0 && this.courses[0].videos && this.courses[0].videos.length > 0) {
      this.playingVideo = this.courses[0].videos[0];
      this.playingVideo.isPlaying = false;
    } else {
      this.playingVideo = null;
    }
  }

  async getVideoUrl() {
    this.youtubeSources = [{
      src: 'https://youtube.com/watch?v=' + this.playingVideo.idVideo,
      provider: 'youtube',
    }];
    // const result: any = await this.appService.getVideoUrl(this.playingVideo._id).toPromise();
    // if (result && result.success) {
    //   this.playingVideo.videoUrls = result.data;
    //   this.playingVideo.videoUrls = this.playingVideo.videoUrls.filter(x => x.format.indexOf('audio') > 0).sort((a, b) => {
    //     if (a.size > b.size) {
    //       return -1;
    //     } else {
    //       if (a.size < b.size) {
    //         return 1;
    //       }
    //     }
    //     return 0;
    //   });
    //   if (result.data.length === 0) {
    //     this.getVideoUrl();
    //   }
    // }
  }

  getThumbnailLink(video: any) {
    return environment.hostApi + '/video/thumbnail/' + video._id + '/image.jpg';
  }

  scrollTop() {
    window.scrollTo(0, 0);
  }

  onErrorPlay() {
  }
}
