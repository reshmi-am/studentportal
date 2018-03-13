
import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { AuthService } from './services/auth.service';

@Injectable()
export class AuthGuardLoggedIn implements CanActivate { 
  constructor(private authService: AuthService,
    private router: Router,) {}; 

  canActivate() {
    if (this.authService.isLoggedIn()) { 
      console.log("User is logged in");
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }
}