import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Injectable} from '@angular/core';

import {Observable} from 'rxjs';
import {AuthService} from "./components/auth/auth.service";

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | boolean
    | import('@angular/router').UrlTree
    | Observable<boolean | import('@angular/router').UrlTree>
    | Promise<boolean | import('@angular/router').UrlTree> {
    return new Promise(async (resolve, reject) => {
      const result = await this.authService.isAuthenticated();
      if (result === 200) {
        resolve(true);
      } else {
        if (result === 401) {
          this.router.navigate(['/auth']);
          resolve(false);
        }
      }
    });
  }
}
