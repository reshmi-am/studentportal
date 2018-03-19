import { Injectable } from '@angular/core';
import { Http , Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { User } from './../shared/model/user';

@Injectable()
export class StudentService {

    private URL : string = "http://localhost:8080/";

    constructor(private http: Http){}

    getAllCourses(): Observable<any> {
       
        return this.http.get(this.URL + "courses")
                    .map((res:Response) => res.json())
                    .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }

    getUserCourses(studentid: number): Observable<any> {
        return this.http.get(this.URL + "courses/" + studentid)
            .map((res:Response) => res.json())
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }

    signupNewStudent(newuser: User) : Observable<any> {
        
        var user  = {
            firstName: newuser.firstname,
            lastName: newuser.lastname,
            email: newuser.email,
            phone: newuser.phone,
            pwd: newuser.password
        }
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        
        return this.http.post(this.URL + "student", user, options)
            .map(res => res)
            .catch((error:any) => Observable.throw(error || 'Server error'));
    }
}