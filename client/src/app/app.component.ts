import { Component } from '@angular/core';
import { MenuItem } from 'primeng/primeng';
import { EventEmitService } from './services/eventemit.service';
import { Router, RoutesRecognized } from '@angular/router';
import { AuthService } from './services/auth.service';
import 'rxjs/add/operator/filter';
import 'rxjs/add/operator/pairwise';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  items: MenuItem[];
  username: string = "";

  constructor(private eventEmiter: EventEmitService,
                private authservice: AuthService,
                private router: Router ) {
    eventEmiter.changeEmitted$.subscribe(
        text => {
            this.username = text.firstName+ " " + text.lastName;
        });
    }

    ngOnInit() {
        this.items = [
            {
                label: 'Home',
                routerLink:  ['/home']
              
            },
            {
                label: 'Student Zone',
                items: [
                    {label: 'Courses', routerLink:  ['/courses']},
                    {label: 'My courses', routerLink:['/studentcourses']},
                    {label: 'Registration', routerLink:['/register']}
                ]
            },
            {
                label: 'Contact Us',
                routerLink:  ['/contact']         
            }
        ];
    }  

    logout(){
        this.username = "";
        this.authservice.logoutUser();
        this.router.navigateByUrl('/home');
    }

}
