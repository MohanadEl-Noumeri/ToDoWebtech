package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class Todo {
    @RestController
    public class HelloController {

        @GetMapping("/")
        public String index() {
            return "Greetings from Spring Boot!";
        }

    }
}
