package com.example.demo;
// Das Backend zeigt die JSon-Daten auf Localhost:8080/todos an!

// Backend zeigt die JSon-Daten die im Frontend erstellt werden auf http://localhost:8080/api/todos!

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
