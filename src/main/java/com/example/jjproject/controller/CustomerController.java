package com.example.jjproject.controller;

import com.example.jjproject.model.Customer;
import com.example.jjproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String showForm() {
        logger.info("Rendering the form page");
        return "index";  // Display index.html template
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("name") String customerName,  // name in the form and "name" in the RequestParam
                             @RequestParam("concertName") String concertName, Model model) {

        logger.info("Form submitted with customerName: {} and concertName: {}", customerName, concertName);

        try {
            // Create a new Customer object
            Customer customer = new Customer(customerName, concertName);

            // Save the customer data to the database
            customerRepository.save(customer);

            // Add a success message
            model.addAttribute("message", "Customer saved successfully!");
            logger.info("Customer saved successfully");

            // Return to the index page with a success message
            return "index";  // Render index.html again with success message
        } catch (Exception e) {
            logger.error("Error occurred while saving customer: ", e);
            model.addAttribute("message", "Error: " + e.getMessage());
            return "index";  // Return to the form page if there's an error
        }
    }
    }
