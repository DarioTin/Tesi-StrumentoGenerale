import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatDialogModule} from '@angular/material/dialog';
import { AppComponent } from './app.component';
import { AuthComponent } from './components/auth/auth.component';
import { TopbarComponent } from './components/topbar/topbar.component';
import { AppRoutingModule } from './app-routing.module';
import {FormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './components/home/home.component';
import {AuthService} from "./components/auth/auth.service";
import { BooklistComponent } from './components/booklist/booklist.component';
import { BookrouteComponent } from './routes/bookroute/bookroute.component';
import {CommonModule} from "@angular/common";
import { OrdersRouteComponent } from './routes/orders-route/orders-route.component';
import { OrderlistComponent } from './components/orderlist/orderlist.component';
import { BookdetailsComponent } from './components/bookdetails/bookdetails.component';
import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import {MatFormFieldModule} from "@angular/material/form-field";
import { OrderdetailsComponent } from './components/orderdetails/orderdetails.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    TopbarComponent,
    HomeComponent,
    BooklistComponent,
    BookrouteComponent,
    OrdersRouteComponent,
    OrderlistComponent,
    BookdetailsComponent,
    OrderdetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule,
    MatDialogModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatFormFieldModule,
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
