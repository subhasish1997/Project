package com.anudip.lms.daoImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anudip.lms.dao.CustomerDao;
import com.anudip.lms.model.Book;
import com.anudip.lms.model.Customer;
import com.anudip.lms.repository.BookRepository;
import com.anudip.lms.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;

    public CustomerDaoImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    
    @Override
    public void removeCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(UUID existingCustomerId, Customer newCustomer) {
        Customer existingCustomer = customerRepository.findById(existingCustomerId).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setName(newCustomer.getName());
            existingCustomer.setPhone(newCustomer.getPhone());
            existingCustomer.setAddress(newCustomer.getAddress());
            customerRepository.save(existingCustomer);
        }
    }

    @Override
    public boolean addBook(UUID customerId, int bookId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (customer != null && book != null) {
            customer.getBooks().add(book);
            customerRepository.save(customer);
            return true;
        } else {
            return false;
        }

    }
}