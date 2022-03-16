import {Component, OnInit} from '@angular/core';
import {OrderService} from "./order.service";
import {formatDate} from "@angular/common";
import {MatDialogModule} from '@angular/material/dialog';


@Component({
  selector: 'app-orderlist',
  templateUrl: './orderlist.component.html',
  styleUrls: ['./orderlist.component.css']
})
export class OrderlistComponent implements OnInit {

  // @ts-ignore
  orders: any[];
  success: boolean = false;

  constructor(private orderService: OrderService) {
  }

  ngOnInit(): void {
    this.updateOrders();
  }

  updateOrders() {
    this.orderService.getOrders().subscribe(resp => {
      this.orders = resp.books;
      this.updateDates();
    })
  }

  updateDates() {
    this.orders.forEach(order => {
      order.date = formatDate(order.date, "dd/MM/YYYY, h:mm", "en-US")
    })
  }

  deleteOrder(item: any) {
    this.orderService.deleteOrder(item.id).subscribe(response =>{
      this.success = true;
      this.updateOrders();
    });
  }

}
