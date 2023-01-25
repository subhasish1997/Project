package com.anudip.lms.dao;

import java.util.List;
import java.util.UUID;

import com.anudip.lms.model.Book;

public interface BookDao {

    void addBook(Book book);
    void removeBook(int id);
    List<Book> getAllBooks();
    void updateBook(int existingBookId, Book newBook);
    List<Book> search(String keyWord);
    boolean addCustomer(int bookId, UUID customerId);
}
