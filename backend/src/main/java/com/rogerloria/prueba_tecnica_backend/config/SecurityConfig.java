package com.rogerloria.prueba_tecnica_backend.config;

import com.rogerloria.prueba_tecnica_backend.filter.ApiKeyFilter;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Nueva forma recomendada
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/usuarios/**").authenticated()
                        .anyRequest().permitAll()
                )
                .addFilterBefore((Filter) new ApiKeyFilter(), FilterSecurityInterceptor.class); // Agrega el filtro personalizado
        return http.build();
    }
}
