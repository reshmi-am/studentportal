import { Component, Output } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { EventEmitter } from 'events';
import { EventEmitService } from '../services/eventemit.service';
import { Router } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls : ['./login.component.css']
})
export class LoginComponent {

    username:string;
    password:string;

    constructor(private service: AuthService,
                private eventEmiter: EventEmitService,
                private router: Router) {
    }

    login(){

        if(this.validateCredentials()){
            this.service.authenticateUser(this.username, this.password).
                    subscribe(response => this.handleLoginResponse(response));
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

        this.emailerror = !this.isValidEmail(this.username);
        this.passworderror = !this.password || this.password.length < 6;
      
        return !(this.emailerror || this.passworderror);
    }

    isValidEmail(email){
        
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
    
    }
} 