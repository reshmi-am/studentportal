import { Component } from '@angular/core';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'course-overview',
  templateUrl: './course.component.html'
})
export class CourseComponent {

    courses: any;

    constructor(private service: StudentService) {
    }
    
    ngOnInit(){
      this.courses = this.service.getAllCourses().
                    subscribe(courses => this.courses = courses);
    }
}

