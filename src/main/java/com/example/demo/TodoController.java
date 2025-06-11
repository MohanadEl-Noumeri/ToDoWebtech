package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class TodoController {

    @Autowired
    TodoService service;


    // auf localhost:8080/todos wird es angezeigt !
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
