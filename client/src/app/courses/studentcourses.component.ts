import { Component } from '@angular/core';
import { StudentService } from '../services/student.service';
import { EventEmitService } from '../services/eventemit.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'students-courses',
  templateUrl: './studentcourses.component.html'
})
export class StudentsCourseComponent {

    courses: any;

    constructor(private service: StudentService,
        private eventEmiter: EventEmitService,
        private authservice: AuthService) {
    }
    
    ngOnInit(){
      this.courses = this.service.getUserCourses(this.authservice.getUser().id).
                    subscribe(courses => this.courses = courses);
    }
}