package com.anudip.lms.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.lms.model.Book;
import com.anudip.lms.repository.BookRepository;

@Service
public class Search {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooks(String keyword) {

        // list to store the raw search results
        List<Book> rawSearchResult = new ArrayList<>();

        // retrieve all books from the repository
        List<Book> books = bookRepository.findAll();

        // if the keyword is numeric, search for a book by id
        if (isNumeric(keyword)) {

            Book book = searchById(books, Integer.parseInt(keyword));

            if (book != null) {
                // add the book to the raw search result list if it is found
                rawSearchResult.add(book);
            }
        } else {
        	
            rawSearchResult.addAll(searchByName(books, keyword));
            rawSearchResult.addAll(searchByAuthor(books, keyword));
            rawSearchResult.addAll(searchByPages(books, keyword));
            rawSearchResult.addAll(searchByPrice(books, keyword));
            
        }
        if (rawSearchResult.size() > 0) {
            if (rawSearchResult.size() > 1) {
                return removeDuplicates(rawSearchResult);
            } else {
            	
                return rawSearchResult;
            }
        } else {
        
            return null;
        }
    }

    public static boolean isNumeric(String input) {

        try {
        	
        	Integer.parseInt(input);
            
            return true;

        } catch (Exception e) {
           
            return false;
        }
    }

    private Book searchById(List<Book> books, int id) 
    {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private List<Book> searchByName(List<Book> books, String keyword)
    {  
        return books.stream()
                .filter(book -> book.getName()
                        .contains(keyword))
                .collect(Collectors.toList());
    }

    private List<Book> searchByAuthor(List<Book> books, String keyword) 
    {

        return books.stream()
                .filter(book -> book.getAuthor()
                        .contains(keyword))
                .collect(Collectors.toList());
    }

    private List<Book> searchByPages(List<Book> books, String keyword) 
    {
   
        return books.stream()
                .filter(book -> book.getPages()
                        .contains(keyword))
                .collect(Collectors.toList());
    }
    
    private List<Book> searchByPrice(List<Book> books, String keyword) {

        
        return books.stream()
                .filter(book -> book.getPages()
                        .contains(keyword))
                .collect(Collectors.toList());
    }

    private List<Book> removeDuplicates(List<Book> list) {

        // create a set to store the unique elements
        Set<Book> set = new LinkedHashSet<>();

        // add all the elements from the list to the set
        set.addAll(list);

        // create a new list from the set and return it
        return new ArrayList<>(set);
    }

}