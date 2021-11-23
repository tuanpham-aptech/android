import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HeaderComponent} from './components/header/header.component';
import {StudentComponent} from './components/student/student.component';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {StudentAdminComponent} from './components/admin/student/student.component';
import {AuthGuard} from './guards/auth.guard';
import {AdminGuard} from './guards/admin.guard';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {VideoAdminComponent} from './components/admin/video/video.component';
import {CourseAdminComponent} from './components/admin/course/course.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NZ_I18N} from 'ng-zorro-antd/i18n';
import {en_US} from 'ng-zorro-antd/i18n';
import {registerLocaleData} from '@angular/common';
import en from '@angular/common/locales/en';
import {NzSelectModule} from 'ng-zorro-antd/select';
import {NzBadgeModule, NzTagModule} from 'ng-zorro-antd';
import {PlyrModule} from 'ngx-plyr';

registerLocaleData(en);

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'subject/:id',
    component: StudentComponent,
    canActivate: [AuthGuard]
  }, {
    path: 'home',
    component: StudentComponent,
    canActivate: [AuthGuard]
  }, {
    path: 'login',
    component: LoginComponent,
  },
  // ----------------ADMIN--------------
  {
    path: 'admin/student',
    component: StudentAdminComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'admin/video',
    component: VideoAdminComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'admin/course',
    component: CourseAdminComponent,
    canActivate: [AdminGuard]
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    StudentComponent,
    StudentAdminComponent,
    LoginComponent,
    VideoAdminComponent,
    CourseAdminComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NzSelectModule,
    NzBadgeModule,
    NzTagModule,
    PlyrModule
  ],
  providers: [{provide: NZ_I18N, useValue: en_US}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
