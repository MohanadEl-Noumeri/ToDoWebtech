package com.example.demo;       // Eine neu erstellte Klasse für das Backend für Meilenstein 3
// damit die Kommunikation auch ohne rendern über localhost 5173/todos funktionieren kann

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Erlaubt CORS für alle Endpunkte
                .allowedOrigins("http://localhost:5173")  // Erlaubt nur dein Vue-Frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE");  // Erlaubte HTTP-Methoden
    }
}
