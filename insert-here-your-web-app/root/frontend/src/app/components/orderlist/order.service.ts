import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../auth/auth.service";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  getOrders(){
    return this.http.post<any>('http://localhost:8081/orders/getOrderPerEmail',{
      email: this.authService.user.getValue().getEmail()
    });
  }

  makeOrder(email: string, token: string, isbn: string, quantity: number){
    return this.http.post('http://localhost:8081/orders/',{
      email: email,
      token: token,
      isbn: isbn,
      quantity: quantity
    });
  }

  getOrderDetails(id: number){
    return this.http.get('http://localhost:8081/orders/' + id);
  }

  deleteOrder(id: number){
    return this.http.delete('http://localhost:8081/orders/' + id);
  }

}
