import { Injectable } from '@angular/core';
import { Http , Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class AuthService {

    private URL : string = "http://localhost:8080/";
    private loggedIn: boolean = false;
    private user:any = null;

    constructor(private http: Http){}

    authenticateUser(email: string, pwd: string):Observable<any> {      
        
            var creds = {
                email: email,
                pwd: pwd
            }
    
            let headers = new Headers({ 'Content-Type': 'application/json' });
            let options = new RequestOptions({ headers: headers });
            
            return this.http.post(this.URL + "auth", creds, options)
                .map(res => res.json())
                .catch((error:any) => Observable.throw(error || 'Server error'));
        }

    logoutUser(){
        this.loggedIn = false;
        this.user = null;
    }

    setLoggedIn(user){
        this.loggedIn = true; 
        this.user = user;
    }

    getUser(){
        return this.user;
    }
    
    isLoggedIn(){
        return this.loggedIn;
    }
}