package com.anudip.lms.daoImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anudip.lms.dao.BookDao;
import com.anudip.lms.model.Book;
import com.anudip.lms.model.Customer;
import com.anudip.lms.repository.BookRepository;
import com.anudip.lms.repository.CustomerRepository;
import com.anudip.lms.service.Search;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Search search;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void removeBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void updateBook(int existingBookId, Book newBook) {
        Book existingBook = bookRepository.findById(existingBookId).orElse(null);
        if (existingBook != null) {
            existingBook.setName(newBook.getName());
            existingBook.setAuthor(newBook.getAuthor());
            existingBook.setPages(newBook.getPages());
            existingBook.setPrice(newBook.getPrice());
            bookRepository.save(existingBook);
        }
    }

    @Override
    public List<Book> search(String keyWord) {
        return search.searchBooks(keyWord);
    }

    @Override
    public boolean addCustomer(int bookId, UUID customerId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (book != null && customer != null) {
            book.getCustomers().add(customer);
            bookRepository.save(book);
            return true;
        } else {
            return false;
        }
    }
}