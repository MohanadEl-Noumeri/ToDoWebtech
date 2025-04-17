package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @GetMapping("/todos")
    public List<Todo> testRouter(){
        return List.of(
                new Todo("Hinzufügen", "Hier fügst du deine Aufgaben ein."),
                new Todo("Löschen", "Hier löschst du deine Aufgaben."),
                new Todo("Bearbeiten", "Hier kannst du deine Aufgaben bearbeiten."),
                new Todo("Erinnern", "Hier wirst du an deinen Aufgaben erinnert."),
                new Todo("Kategorisieren", "Hier kannst du deine Aufgaben Kategorisieren.")
        );
    }
}
