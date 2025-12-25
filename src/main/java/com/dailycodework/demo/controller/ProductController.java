package com.dailycodework.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public String getAllProducts() {
        return "Welcome to Dream Shops API! Products endpoint working.";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Dream Shops!";
    }
}
