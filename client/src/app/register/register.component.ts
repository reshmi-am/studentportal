import { Component } from '@angular/core';
import { StudentService } from '../services/student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'register',
  templateUrl: 'register.component.html',
  styleUrls: ['./register.component.css']
})
export class CourseRegisterComponent {
    modes: any = [
        {label: "Online" , value:"Online"},
        {label: "Distant", value:"Distant"},
        {label: "Regular", value:"Regular"}
    ]
    types: any = [
        {label: "Masters" , value:"Masters"},
        {label: "Bachelors", value:"Bachelors"},
        {label: "Diploma", value:"Diploma"},
        {label: "Certificate", value:"Certificate"}
    ]
    programmes: any = [

    ]

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
}