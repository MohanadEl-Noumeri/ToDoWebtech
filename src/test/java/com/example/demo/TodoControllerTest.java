package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// Tests laufen durch!
@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TodoRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        repository.deleteAll();
    }

    @Test
    void testAddTodo() throws Exception {
        Todo todo = new Todo(null, "Mathe lernen", "Kapitel 6", false);

        mockMvc.perform(post("/api/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Mathe lernen"));
    }

    @Test
    void testGetTodos() throws Exception {
        repository.save(new Todo(null, "Lesen", "Buch weiterlesen", false));

        mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title").value("Lesen"));
    }

    @Test
    void testToggleTodo() throws Exception {
        Todo todo = repository.save(new Todo(null, "Test", "Beschreibung", false));

        mockMvc.perform(put("/api/todos/" + todo.id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.completed").value(true));
    }

    @Test
    void testDeleteOneTodo() throws Exception {
        Todo todo = repository.save(new Todo(null, "ToDelete", "", false));

        mockMvc.perform(delete("/api/todos/" + todo.id))
                .andExpect(status().isNoContent());

        // verify it's gone
        mockMvc.perform(get("/api/todos"))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void testDeleteAllTodos() throws Exception {
        repository.save(new Todo(null, "Eins", "", false));
        repository.save(new Todo(null, "Zwei", "", false));

        mockMvc.perform(delete("/api/todos"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/todos"))
                .andExpect(jsonPath("$", hasSize(0)));
    }
}

