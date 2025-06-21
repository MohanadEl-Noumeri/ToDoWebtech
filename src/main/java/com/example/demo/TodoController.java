package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id){
     Optional<Todo> todoOpt = repository.findById(id);
     if(todoOpt.isEmpty()) {
         return ResponseEntity.notFound().build();
     }
     Todo todo = todoOpt.get();
     todo.completed = !todo.completed;
     repository.save(todo);
     return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteOneTodo(@PathVariable Long id) {
        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}