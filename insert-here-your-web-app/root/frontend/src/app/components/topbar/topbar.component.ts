import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from "../auth/auth.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopbarComponent implements OnInit, OnDestroy {
  isAuthenticated = false;
  private userSub: Subscription | undefined;
  constructor(public authService: AuthService) { }

  ngOnInit(): void {
    this.userSub = this.authService.user.subscribe(user =>{
      this.isAuthenticated = !!user;
    });
    console.log("Creato");
  }

  ngOnDestroy(): void {
    // @ts-ignore
    this.userSub.unsubscribe();
    console.log("Distrutto");
  }

  onLogout() {
    this.authService.logout();
  }
}
