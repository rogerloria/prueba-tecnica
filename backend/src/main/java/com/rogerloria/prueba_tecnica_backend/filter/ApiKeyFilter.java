package com.rogerloria.prueba_tecnica_backend.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rogerloria.prueba_tecnica_backend.model.ErrorResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
public class ApiKeyFilter extends GenericFilterBean {

    private static final String API_KEY = "prueba-tecnica-llave-secreta";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String apiKey = httpRequest.getHeader("X-API-KEY");

        if (apiKey == null || !apiKey.equals(API_KEY)) {
            // 1. Crear el objeto de respuesta de error
            ErrorResponse errorResponse = new ErrorResponse("Acceso no autorizado", HttpServletResponse.SC_UNAUTHORIZED);

            // 2. Convertir a JSON
            String jsonError = new ObjectMapper().writeValueAsString(errorResponse);

            // 3. Configurar la respuesta HTTP
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType("application/json");
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.getWriter().write(jsonError);
            return;
        }
        System.out.println("API Key verificada correctamente."); // Log
        chain.doFilter(request, response);
    }
}
