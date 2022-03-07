package com.dariotintore.backend.Controller;

import java.util.List;
import java.util.Optional;


import com.dariotintore.backend.Entity.Book;
import com.dariotintore.backend.Service.BookService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @PostMapping(value = "/")
    public ResponseEntity<JSONObject> saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JSONObject> deleteBook(@PathVariable Long id) {
        return bookService.deleteBookById(id);
    }

    @PostMapping("/availabile/")
    public ResponseEntity<JSONObject> isBookAvailable(@RequestBody JSONObject body) {
        String isbn = (String) body.get("isbn");
        int quantity = (int) body.get("quantity");
        return bookService.checkBookAvailability(isbn, quantity);
    }

    @PostMapping(value = "/quantity")
    public ResponseEntity<JSONObject> editQuantity(@RequestBody JSONObject body) {
        String isbn = (String) body.get("isbn");
        int quantity = (int) body.get("quantityToSubtract");
        return bookService.subtractQuantity(isbn, quantity);
    }

    @GetMapping(value = "/latest/{numberOfBooksRequired}")
    public List<Book> getLatestBooks(@PathVariable Long numberOfBooksRequired) {
        return bookService.getLatestBooks(numberOfBooksRequired);
    }
}

