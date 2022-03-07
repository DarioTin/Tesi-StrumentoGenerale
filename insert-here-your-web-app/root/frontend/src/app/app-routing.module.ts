import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CommonModule } from '@angular/common';
import {AuthComponent} from "./components/auth/auth.component";
import {AppComponent} from "./app.component";
import {HomeComponent} from "./components/home/home.component";
import {BookrouteComponent} from "./routes/bookroute/bookroute.component";
import {OrdersRouteComponent} from "./routes/orders-route/orders-route.component";
import {AuthGuard} from "./auth.guard";



const appRoutes: Routes = [
  { path: 'auth', component: AuthComponent},
  { path: 'home', component: HomeComponent },
  { path: 'books', component: BookrouteComponent, canActivate: [AuthGuard]},
  { path: 'orders', component: OrdersRouteComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
