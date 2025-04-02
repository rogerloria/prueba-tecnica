package com.rogerloria.prueba_tecnica_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite solicitudes de cualquier origen para todos los endpoints
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173/")  // Cambia al puerto de tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos que permites
                .allowedHeaders("*") // Permite todos los headers
                .allowCredentials(true); // Si necesitas enviar credenciales (cookies, auth headers)
    }
}
