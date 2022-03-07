package com.dariotintore.backend.Service;

import com.dariotintore.backend.Entity.Book;
import com.dariotintore.backend.Repository.BookRepository;
import com.dariotintore.backend.Utils.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.server.ResponseStatusException;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private  BookRepository BookRepository;

    public List<Book> getAllBooks() {
        return BookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        Optional<Book> user = BookRepository.findById(id);
        if (!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public ResponseEntity<JSONObject> saveBook(Book book) {
        if (bookAlreadyPresent(book.getIsbn()))
            return ResponseHelper.buildBadRequestResponse("Book already present");
        BookRepository.save(book);
        return ResponseHelper.buildOkResponse("Book added");
    }

    public ResponseEntity<JSONObject> deleteBookById(Long id) {
        if (bookDoesExist(id)) {
            BookRepository.deleteById(id);
            return ResponseHelper.buildOkResponse("Book deleted");
        } else {
            return ResponseHelper.buildNotFoundResponse("Book not found");
        }
    }

    private boolean bookDoesExist(Long id) {
        Optional<Book> user = BookRepository.findById(id);
        if (user.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean bookAlreadyPresent(String isbn) {
        Long check;
        check = BookRepository.checkIsbnAlreadyExists(isbn);
        if (check > 0)
            return true;
        else
            return false;
    }

    public ResponseEntity<JSONObject> checkBookAvailability(String isbn, int quantity) {
        if (!bookAlreadyPresent(isbn))
            return ResponseHelper.buildNotFoundResponse("Book not found");
        int availability = BookRepository.getBookQuantity(isbn);
        if (availability >= quantity)
            return ResponseHelper.buildOkResponse("Books available");
        else
            return ResponseHelper.buildBadRequestResponse("Books not available");
    }

    @Transactional
    public ResponseEntity<JSONObject> subtractQuantity(String isbn, int quantity) {
        int actualQuantity = BookRepository.getBookQuantity(isbn);
        int newQuantity = actualQuantity - quantity;
        if (!bookAlreadyPresent(isbn))
            return ResponseHelper.buildNotFoundResponse("Book not found");
        BookRepository.editQuantityByIsbn(isbn, newQuantity);
        return ResponseHelper.buildOkResponse("Quantity updated");
    }

    public Book findBookByIsbn(String isbn){
        return BookRepository.findByIsbn(isbn);
    }

    public List<Book> getLatestBooks(Long numberOfBooksRequired) {
        return BookRepository.getLatestBooks(numberOfBooksRequired);
    }
}
