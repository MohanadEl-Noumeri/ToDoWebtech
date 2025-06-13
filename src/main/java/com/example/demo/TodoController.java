package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoRepository repository;

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return (List<Todo>) repository.findAll();
    }

    @DeleteMapping("/todos")
    public void deleteAllTodos() {
        repository.deleteAll();
    }
}