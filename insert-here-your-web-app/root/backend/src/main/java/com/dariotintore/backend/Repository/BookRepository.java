package com.dariotintore.backend.Repository;


import com.dariotintore.backend.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT COUNT(*) AS nelem FROM book B WHERE B.isbn = ?1", nativeQuery = true)
    Long checkIsbnAlreadyExists(String isbn);

    @Query(value = "SELECT quantity FROM book B WHERE B.isbn = ?1", nativeQuery = true)
    int getBookQuantity(String isbn);

    @Modifying
    @Query(value = "UPDATE book B set B.quantity = ?2 WHERE B.isbn = ?1", nativeQuery = true)
    void editQuantityByIsbn(String isbn, int quantity);

    Book findByIsbn(String isbn);

    @Query(value = "SELECT * FROM book B ORDER BY B.id DESC LIMIT ?1 ", nativeQuery = true)
    List<Book> getLatestBooks(Long numberOfBooksRequired);
}
