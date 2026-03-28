package com.devops.product_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
         return "Hello DevOps CI/CD Pipeline 4";
    }

@GetMapping("/status")
    public String status() {
        return "Application 8";
    }
}

