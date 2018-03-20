import { Component } from '@angular/core';
import { StudentService } from '../services/student.service';
import { AuthService } from '../services/auth.service';
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
    selectedProgramme: any;
    
    courses: any;

    constructor(private service: StudentService,
                private authservice: AuthService,
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

        this.service.registerCourse(this.authservice.getUser().id, this.selectedProgramme.id).
                subscribe(response =>{ this.handleRegistrationSuccess()});
        
    }

    handleRegistrationSuccess(){
        
        this.router.navigateByUrl("/studentcourses");
    }

    selectprogram(event){  
        this.selectedMode = event.value.mode;
        this.selectedType = event.value.type;
    }
}