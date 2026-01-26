package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Chào mừng đến với Spring Boot! Ứng dụng đã chạy thành công!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World from Spring Boot!";
    }
}
