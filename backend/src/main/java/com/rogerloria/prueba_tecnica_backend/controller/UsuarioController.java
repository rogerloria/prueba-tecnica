package com.rogerloria.prueba_tecnica_backend.controller;

import com.rogerloria.prueba_tecnica_backend.model.ErrorResponse;
import com.rogerloria.prueba_tecnica_backend.model.Usuario;
import com.rogerloria.prueba_tecnica_backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable String id) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        System.out.println("🔹 JSON recibido: " + usuario);
        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario);
        System.out.println("Usuario guardado en MongoDB: " + usuarioGuardado);
        return ResponseEntity.ok(usuarioGuardado);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> eliminarUsuario(@PathVariable String id)  {
        try {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } catch (NoSuchElementException ex) {
            // Crear un objeto ErrorResponse
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
