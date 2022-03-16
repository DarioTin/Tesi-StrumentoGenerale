import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {BookService} from "./book.service";
import {Book} from "../../model/book.model";
import {OrderService} from "../orderlist/order.service";
import {AuthService} from "../auth/auth.service";
import {BookdetailsComponent} from "../bookdetails/bookdetails.component";
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-booklist', templateUrl: './booklist.component.html', styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {

  @Output() notifyPurchase: EventEmitter<any> = new EventEmitter();

  // @ts-ignore
  books: any[];
  @Input()
  booksToDisplay: string = '';
  quantity: number = 1;
  success: boolean = false;
  fail: boolean = false;

  constructor(private bookService: BookService, private orderService: OrderService, private authService: AuthService, public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.updateBooks();
  }

  clickMethod(book: Book) {
    this.resetMessages();
    if (confirm("Are you sure to buy " + book.title)) {
      this.orderService.makeOrder(this.authService.user.getValue().getEmail(), this.authService.user.getValue().getToken(), book.isbn, this.quantity).subscribe(response => {
        this.updateBooks();
        this.notifyPurchase.emit(1);
      }, error => {
        this.notifyPurchase.emit(0);
      });
    }
  }

  updateBooks() {
    if (this.booksToDisplay == '') {
      this.bookService.getBooks().subscribe(resp => {
        this.books = resp;
      })
    } else {
      this.bookService.getLimitedBooks(this.booksToDisplay).subscribe(resp => {
        this.books = resp;
      })
    }
  }

  changeQuantity($event: Event) {
    // @ts-ignore
    this.quantity = event.target.value;
  }

  resetMessages() {
    this.success = false;
    this.fail = false;
  }

  showDialog(book: { title: any; description: any; author: any, publisher: any }) {
    this.dialog.open(BookdetailsComponent, {
      data: book,
    });
  }
}
