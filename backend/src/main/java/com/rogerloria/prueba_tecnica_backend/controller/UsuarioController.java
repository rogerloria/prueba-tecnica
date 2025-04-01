package com.rogerloria.prueba_tecnica_backend.controller;

import com.rogerloria.prueba_tecnica_backend.model.Usuario;
import com.rogerloria.prueba_tecnica_backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String id)  {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
