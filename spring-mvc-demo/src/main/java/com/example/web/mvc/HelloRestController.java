package com.example.web.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping("/hellorest")
    public String handleHelloRest() {
        String message = "Hello, Spring MVC!";
        return message;
    }
}
