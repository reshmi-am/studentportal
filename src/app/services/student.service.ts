import { Injectable } from '@angular/core';
import { Http , Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

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
}