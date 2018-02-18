import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { AlertComponent } from './alert.component';
import { CourseComponent } from './courses/course.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { StudentsCourseComponent } from './courses/studentcourses.component';
import { CourseRegisterComponent } from './register/register.component';

import { MenubarModule, DataTableModule, 
  FileUploadModule, DropdownModule, DialogModule }  from 'primeng/primeng';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { StudentService } from './services/student.service';
import { AuthService } from './services/auth.service';
import { EventEmitService } from './services/eventemit.service';
import { FormsModule } from '@angular/forms';
import { AuthGuardLoggedIn } from './auth.guard';

const appRoutes: Routes = [
  { path: '', redirectTo: 'home' , pathMatch: 'full'},
  { path: 'home', component: HomeComponent },
  { path: 'courses', component: CourseComponent },
  { path: 'login', component: LoginComponent },
  { path: 'studentcourses', component: StudentsCourseComponent, canActivate: [AuthGuardLoggedIn] },
  { path: 'register', component: CourseRegisterComponent, canActivate: [AuthGuardLoggedIn] }
];

@NgModule({
  declarations: [
    AppComponent,
    CourseComponent,
    AlertComponent,
    HomeComponent,
    LoginComponent,
    StudentsCourseComponent,
    CourseRegisterComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } 
    ),
    HttpModule,
    MenubarModule,
    FormsModule,
    DataTableModule,
    BrowserAnimationsModule,
    DropdownModule,
    DialogModule,
    FileUploadModule
  ],
  providers: [StudentService, AuthService, EventEmitService, AuthGuardLoggedIn],
  bootstrap: [AppComponent]
})
export class AppModule { }
