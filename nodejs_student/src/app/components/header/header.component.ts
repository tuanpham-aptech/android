import {Component, OnInit} from '@angular/core';
import {AppService} from '../../services/app.service';
import {Student} from '../../models/student';
import {environment} from '../../../environments/environment';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  user: Student;
  subjects: Array<any>;
  menu = false;

  constructor(private appService: AppService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.appService.authEvent.subscribe(() => {
      this.user = environment.user;
      this.subjects = environment.init.subjects;
    });
  }

  logout() {
    localStorage.clear();
    environment.user = null;
    this.router.navigate(['/login']);
    this.appService.authEvent.emit();
    this.menu=false;
  }

  toggleMenu() {
    this.menu = !this.menu;
  }
}
