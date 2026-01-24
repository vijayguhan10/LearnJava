package com.example.Liabrary.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    // System.out.println("Home Controller Initialized");
    @GetMapping("/")
    public String home() {
        return "<h1 style={{\"color\":\"green\"}}>Application Started Successfully! </h1>" +
                "<p>Welcome to the Library Management System</p>" +
                "<p>API Endpoints available at <a href='/books'>/books</a></p>";
    }
}
