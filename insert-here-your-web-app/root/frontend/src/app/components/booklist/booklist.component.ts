import {Component, Input, OnInit} from '@angular/core';
import {BookService} from "./book.service";
import {Book} from "../../model/book.model";
import {OrderService} from "../orderlist/order.service";
import {AuthService} from "../auth/auth.service";

@Component({
  selector: 'app-booklist', templateUrl: './booklist.component.html', styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {

  // @ts-ignore
  books: any[];
  @Input()
  booksToDisplay: string = '';
  quantity: number = 1;
  success: boolean = false;
  fail: boolean = false;

  constructor(private bookService: BookService, private orderService: OrderService, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.updateBooks();
  }

  clickMethod(book: Book) {
    this.resetMessages();
    if (confirm("Are you sure to buy " + book.title)) {
      this.orderService.makeOrder(this.authService.user.getValue().getEmail(), this.authService.user.getValue().getToken(), book.isbn, this.quantity).subscribe(response => {
        this.updateBooks();
        this.success = true;
      }, error => {
        this.fail = true;
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

  resetMessages(){
    this.success = false;
    this.fail = false;
  }
}
