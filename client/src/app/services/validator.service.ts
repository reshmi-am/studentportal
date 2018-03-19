import { Injectable } from '@angular/core';


@Injectable()
export class ValidatorService {

    isValidEmail (email: string) : boolean{
        
        if(email == null || email.trim().length == 0) {
            return false;
        }
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
    }

    isValidPassword (pwd: string) :  boolean {

        if(pwd == null || pwd.trim().length == 0) {
            return false;
        }

        return pwd.trim().length >= 6;
    }

    isValidPhone(phone: string ) : boolean {
        if(phone == null || phone.trim().length == 0) {
            return false;
        }

        var regex = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
        return regex.test(phone.trim());

    }

    isValidName(name : string) : boolean{
        if(name == null || name.trim().length == 0) {
            return false;
        }

        var regex =  /^[a-zA-Z\-]+$/;
        return regex.test(name.trim());
    }
}