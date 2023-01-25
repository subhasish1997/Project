package com.anudip.lms.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.lms.daoImpl.BookDaoImpl;
import com.anudip.lms.daoImpl.CustomerDaoImpl;
import com.anudip.lms.model.Book;
import com.anudip.lms.model.Customer;
import com.anudip.lms.service.Search;

@RestController
public class MainController {

    @Autowired
    private BookDaoImpl bookDao;

    @Autowired
    private CustomerDaoImpl customerDao;

    @Autowired
    private Search search;

    @GetMapping("/")
    public String home() {
        return "Welcome to LMS";
    }

    @PostMapping("/addbook")
    public void addBook(@RequestBody Book book) {
        bookDao.addBook(book);
    }

    @PostMapping("/addcustomer")
    public void addCustomer(@RequestBody Customer customer) {
        customerDao.addCustomer(customer);
    }

    @DeleteMapping("/deletebook{id}")
    public void removeBook(@PathVariable int id) {
        bookDao.removeBook(id);
    }

    @PostMapping("/deletecustomer/{id}")
    public void deleteCustomer(@PathVariable UUID id) {
        customerDao.removeCustomer(id);
    }

    @PutMapping("/updatebook{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book newBook) {
        bookDao.updateBook(id, newBook);
    }

    @PutMapping("/updatecustomer/{id}")
    public void updateCustomer(@PathVariable UUID id, @RequestBody Customer customer) {
        customerDao.updateCustomer(id, customer);
    }

    @GetMapping("/getallbook")
    public List<Book> getAllBook() {
        return bookDao.getAllBooks();
    }

    @GetMapping("/search/{keyword}")
    public List<Book> searchBook(@PathVariable String keyword) {
        return search.searchBooks(keyword);
    }

    @PutMapping("/addcustomertobook{bookid}/customerid{customerid}")
    public ResponseEntity<Void> addCustomerToBook(@PathVariable int bookid, @PathVariable UUID customerid) {
        if (bookDao.addCustomer(bookid, customerid)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/addbooktocustomer{customerid}/customerid{bookid}")
    public ResponseEntity<Void> addBookToCustomer(@PathVariable int customerid, @PathVariable UUID bookid) {
        if (customerDao.addBook(bookid, customerid)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}