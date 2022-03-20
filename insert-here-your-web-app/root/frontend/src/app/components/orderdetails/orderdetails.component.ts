import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {OrderService} from "../orderlist/order.service";

@Component({
  selector: 'app-orderdetails',
  templateUrl: './orderdetails.component.html',
  styleUrls: ['./orderdetails.component.css']
})
export class OrderdetailsComponent implements OnInit {

  order: any;
  success: boolean = false;
  constructor(@Inject(MAT_DIALOG_DATA) public data: any,public dialogRef: MatDialogRef<OrderdetailsComponent>, private orderService: OrderService) { }

  ngOnInit(): void {
    this.order = this.data;
  }

  deleteOrder(item: any) {
    this.orderService.deleteOrder(item.id).subscribe(response =>{
      this.success = true;
      this.dialogRef.close(1);
    });
  }


}
