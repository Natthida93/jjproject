package com.example.jjproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Optionally, log the error details here
        return "error"; // Return the error.html template
    }
}
