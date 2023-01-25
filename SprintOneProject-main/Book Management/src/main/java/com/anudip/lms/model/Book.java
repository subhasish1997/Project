package com.anudip.lms.model;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private int id;
    private String name;
    private String author;
    private String pages;
    private int price;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }
    )
    private Set<Customer> customers = new HashSet<>();

    public Book() {
        this.id = ThreadLocalRandom.current().nextInt(100000, 1000000);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPages() {
        return pages;
    }
    public void setPages(String pages) {
        this.pages = pages;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Set<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author  + ", pages="
                + pages + ", price=" + price + ", customers=" + customers + "]";
    }

}