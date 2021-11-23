import {Component, OnInit} from '@angular/core';
import {AppService} from '../../services/app.service';
import {Router} from '@angular/router';
import {environment} from '../../../environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = '';
  password: '';

  constructor(private appService: AppService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.autoLogin();
  }

  async autoLogin() {
    const localUsername = localStorage.getItem('username');
    const localPassword = localStorage.getItem('password');
    if (localPassword && localUsername) {
      const result = await this.appService.login(localUsername, localPassword).toPromise();
      if (result && result.success) {
        console.log(result);
        const user = result.data;
        environment.user = user;
        if (user.role === 'admin') {
          this.router.navigate(['/admin/student']);
        } else {
          this.router.navigate(['/home']);
        }
      }
      this.appService.authEvent.emit();
    }
  }

  async submitLogin() {
    const result = await this.appService.login(this.username, this.password).toPromise();
    if (result && result.success) {
      console.log(result);
      const user = result.data;
      environment.user = user;
      if (user.role === 'admin') {
        this.router.navigate(['/admin/student']);
      } else {
        this.router.navigate(['/home']);
      }

      localStorage.setItem('username', this.username);
      localStorage.setItem('password', this.password);
    } else {
      alert('Sai tên đăng nhập hoặc mật khẩu!!!');
    }
    this.appService.authEvent.emit();
  }

}
