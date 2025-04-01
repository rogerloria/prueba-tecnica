package com.rogerloria.prueba_tecnica_backend.repository;

import com.rogerloria.prueba_tecnica_backend.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {}

