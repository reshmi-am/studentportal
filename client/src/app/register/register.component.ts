import { Component } from '@angular/core';
import { StudentService } from '../services/student.service';
import { Router } from '@angular/router';
import { WebEntity } from '../shared/webentity';

@Component({
  selector: 'register',
  templateUrl: 'register.component.html',
  styleUrls: ['./register.component.css']
})
export class CourseRegisterComponent extends WebEntity{

    selectedMode: string = "";
    selectedType: string = "";

    programmes: any = [];

    courses: any;

    constructor(private service: StudentService,
                private router: Router) {
                    super();
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

    proceed(){
        this.showAlert("Thank you for registering. You will receive an email with payment directions.");
    }

    selectprogram(event){
        
        this.selectedMode = event.value.mode;
        this.selectedType = event.value.type;
    }
}