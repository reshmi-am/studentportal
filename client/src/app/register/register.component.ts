import { Component } from '@angular/core';
import { StudentService } from '../services/student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'register',
  templateUrl: 'register.component.html',
  styleUrls: ['./register.component.css']
})
export class CourseRegisterComponent {

    selectedMode: string = "";
    selectedType: string = "";

    programmes: any = [];

    courses: any;

    constructor(private service: StudentService,
                private router: Router) {
    }
    
    ngOnInit(){
      this.courses = this.service.getAllCourses().
                    subscribe(courses =>{ this.courses = courses; this.fillCourses()});
    }

    fillCourses(){
        this.courses.forEach(element => {
            this.programmes.push({label: element.degree + ":" + element.name , value:element});
        });
    }
    
    showalert:boolean = false;
    message: string = "";
    proceed(){
        this.showalert = true;
        this.message = "Thank you for registering. You will receive an email with payment directions.";
    }

    selectprogram(event){
        console.log(event);
        this.selectedMode = event.value.mode;
        this.selectedType = event.value.type;
    }
}