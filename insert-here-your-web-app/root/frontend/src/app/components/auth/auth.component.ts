import {Component} from '@angular/core';
import {NgForm} from '@angular/forms';
import {AuthService} from "./auth.service";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html'
})
export class AuthComponent {
  isLoginMode = true;
  fail1: boolean = false; // Wrong email or password
  fail2: boolean = false; // Server has a problem
  fail3: boolean = false; // Email already registered
  fail4: boolean = false; // Password must contain:
  fail5: boolean = false; // Invald email

  constructor(private authService: AuthService, private router: Router) {
  }

  resetErrors(){
    this.fail1 = false;
    this.fail2 = false;
    this.fail3 = false;
    this.fail4 = false;
  }

  onSwitchMode() {
    this.isLoginMode = !this.isLoginMode;
    this.resetErrors();
  }

  onSubmit(form: NgForm) {
    const email = form.value.email;
    const password = form.value.password;
    this.resetErrors();
    if (this.isLoginMode) {
      this.authService.login(email, password).subscribe(response => {
        this.router.navigate(['/home']);
      }, error => {
        this.handleError(error);
      });
    } else {
      this.handleSignup(email, password);
    }
    form.reset();
  }

  handleSignup(email: string, password: string){
    if(this.checkSignupForm(email, password)){
      this.authService.signup(email, password).subscribe(response => {
        this.authService.login(email, password).subscribe(response => {
          this.router.navigate(['/home']);
        });
      }, error => {
        this.fail3 = true;
      });
    } else{
      this.fail4 = true;
    }
  }

  handleError(error: HttpErrorResponse) {
    switch (error.status) {
      case 400:
        this.fail1 = true;
        break;
      default:
        this.fail2 = true;
        break;
    }
  }

  checkSignupForm(email: string, password: string){
    const number = /\d/;
    const uppercase = /[A-Z]/;
    console.log(number.test(password));
    console.log(uppercase.test(password))
    return number.test(password) && uppercase.test(password);
  }

}
