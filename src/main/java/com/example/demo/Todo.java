package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;    // von Long auf long geändert! Primitive Datentypen sind mit typescript kompatibler
    public String title;
    public String description;
    public boolean completed = false; // Direkt initialisiert

    public Todo() {}
    public Todo(Long id, String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }
}


