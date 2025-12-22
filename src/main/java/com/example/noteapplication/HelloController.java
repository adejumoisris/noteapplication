package com.example.noteapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/well")
    public String Hello() {
        return "Welcome to the world";
    }
}
