import { Component, OnInit } from '@angular/core';
import { User } from './../shared/model/user';
import { StudentService } from './../services/student.service';
import { Router } from '@angular/router';
import { WebEntity } from './../shared/webentity';
import { ValidatorService } from './../services/validator.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  providers: [User]
})
export class SignupComponent extends WebEntity{

  constructor(private user : User,
    private service: StudentService,
    private router: Router,
    private validator : ValidatorService) {
    super();
   }

  ngOnInit() {
  }

  signup(){
    
    if( ! this.isValidInput() ){
      this.showAlert("Please enter all details !!!");
    } else{
      this.proceedSignup();
    }
  }

  isValidInput() : boolean{

    let usr = this.user;

    return (usr != null &&
      this.validator.isValidEmail( usr.email ) && 
      this.validator.isValidPassword ( usr.password ) && 
      this.validator.isValidPassword ( usr.rpassword ) &&
      usr.rpassword == usr.password &&
      this.validator.isValidName (usr.firstname ) &&
      this.validator.isValidName (usr.lastname) &&
      this.validator.isValidPhone (usr.phone) ) ;
  }

  proceedSignup(){
    this.service.signupNewStudent(this.user).
      subscribe(response => this.handleSignupComplete());
  }
  
  handleSignupComplete(){
    this.router.navigateByUrl("/login");
  }
}
