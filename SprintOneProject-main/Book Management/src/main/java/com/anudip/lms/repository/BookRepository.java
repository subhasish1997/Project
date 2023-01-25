package com.anudip.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.lms.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
