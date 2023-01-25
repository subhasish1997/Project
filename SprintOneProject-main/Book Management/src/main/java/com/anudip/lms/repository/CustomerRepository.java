package com.anudip.lms.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.lms.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
