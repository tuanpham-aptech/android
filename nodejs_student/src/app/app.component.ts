import {Component, OnInit} from '@angular/core';
import {AppService} from './services/app.service';
import {environment} from '../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'LearningVideoClient';
  loading = true;

  constructor(private appService: AppService) {
  }

  ngOnInit(): void {
    this.appService.init().subscribe((value: any) => {
      if (value && value.success) {
        environment.init = value.data;
        this.loading = false;
      }
    });
  }
}
