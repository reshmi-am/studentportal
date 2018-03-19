import { Component, Output } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { EventEmitter } from 'events';
import { EventEmitService } from '../services/eventemit.service';
import { Router } from '@angular/router';
import { ValidatorService } from '../services/validator.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls : ['./login.component.css']
})
export class LoginComponent {

    username:string;
    password:string;

    constructor(private service: AuthService,
                private validator: ValidatorService,
                private eventEmiter: EventEmitService,
                private router: Router) {
    }

    login(){

        if(this.validateCredentials()){
            this.service.authenticateUser(this.username, this.password).
                    subscribe(response => this.handleLoginResponse(response.json()));
        }

    }

    handleLoginResponse(response){
    
        this.eventEmiter.emitLoginSuccess(response);
        this.service.setLoggedIn(response);
     
        this.router.navigateByUrl("/home");
    }

    emailerror: boolean = false;
    passworderror: boolean = false;

    validateCredentials(){

        this.emailerror = !this.validator.isValidEmail(this.username);
        this.passworderror = !this.validator.isValidPassword ( this.password );
      
        return !(this.emailerror || this.passworderror);
    }
} 