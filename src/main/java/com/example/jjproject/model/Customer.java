package com.example.jjproject.model;

import jakarta.persistence.*;


@Entity  // Marks this class as an entity for JPA
@Table(name = "customer_info")
public class Customer {

    @Id  // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates unique values for the 'id' field
    private Long id;

    private String customerName;
    private String concertName;

    // No-argument constructor required by Hibernate (JPA)
    public Customer() {
    }

    // Constructor for easier creation of Customer objects (with arguments)
    public Customer(String customerName, String concertName) {
        this.customerName = customerName;
        this.concertName = concertName;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getConcertName() {
        return concertName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }
}
