@Component({
  selector: 'app-bookroute',
  templateUrl: './bookroute.component.html',
  styleUrls: ['./bookroute.component.css']
})
export class BookrouteComponent implements OnInit {

  constructor() { }

  success:boolean = false;
  fail:boolean = false;

  ngOnInit(): void {
  }

  // @ts-ignore
  notify(evt){
    if(evt == 1){
      this.setSuccess();
    }else{
      this.setFail();
    }
  }

  setSuccess(){
    setTimeout(()=>{
      this.success = !this.success;
    },5000);
    this.success = !this.success;
  }

  setFail(){
    setTimeout(()=>{
      this.fail = !this.fail;
    },5000);
    this.fail = !this.fail;  }

}

import { Component, OnInit } from '@angular/core';
