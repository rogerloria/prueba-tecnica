package com.rogerloria.prueba_tecnica_backend.repository;

import com.rogerloria.prueba_tecnica_backend.model.SolicitudCredito;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SolicitudCreditoRepository extends MongoRepository<SolicitudCredito, String> {}
