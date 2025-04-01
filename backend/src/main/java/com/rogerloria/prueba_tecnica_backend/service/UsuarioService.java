package com.rogerloria.prueba_tecnica_backend.service;

import com.rogerloria.prueba_tecnica_backend.model.Usuario;
import com.rogerloria.prueba_tecnica_backend.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class); // logs
    private final UsuarioRepository usuarioRepository; // Inyectar el repositorio

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerUsuarios() {
        logger.info("Obteniendo todos los usuarios");
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(String id) {
        logger.info("Buscando usuario con ID: {}", id);
        return usuarioRepository.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        logger.info("Guardando usuario: {}", usuario);
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(String id) {
        logger.info("Intentando eliminar usuario con ID: {}", id);
        if(!usuarioRepository.existsById(id)) {
            logger.warn("No se encontró usuario con ID: {} para eliminar", id);
            throw new NoSuchElementException("El usuario que intentas eliminar no existe");
        }
        usuarioRepository.deleteById(id);
        logger.info("Usuario con identificador {} fue eliminado correctamente", id);
    }
}
