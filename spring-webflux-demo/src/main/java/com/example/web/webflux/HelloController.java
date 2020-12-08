package com.example.web.webflux;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String handleHello(Model model) {
        String message = "Hello, Spring WebFlux!";
        model.addAttribute("message", message);
        return "hello";
    }
}
