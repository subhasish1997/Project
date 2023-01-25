package com.anudip.lms.dao;

import java.util.UUID;

import com.anudip.lms.model.Customer;

public interface CustomerDao {

    void addCustomer(Customer customer);
    void removeCustomer(UUID id);
    void updateCustomer(UUID existingCustomerId, Customer newCustomer);
    boolean addBook(UUID customerId, int bookId);
}
