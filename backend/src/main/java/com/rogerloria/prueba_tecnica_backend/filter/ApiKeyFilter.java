package com.rogerloria.prueba_tecnica_backend.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
public class ApiKeyFilter extends GenericFilterBean {

    private static final String API_KEY = "prueba-tecnica-llave-secreta";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String apiKey = httpRequest.getHeader("X-API-KEY");
        if (apiKey == null || !apiKey.equals(API_KEY)) {
            throw new ServletException("Acceso no autorizado");
        }

        chain.doFilter(request, response);
    }
}
