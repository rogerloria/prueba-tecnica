package com.rogerloria.prueba_tecnica_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "solicitudes")
public class SolicitudCredito {
    @Id
    private String id;
    private Usuario usuario;
    private LocalDate fechaSolicitud;
    private String estado; // "aprobada", "rechazada", "pendiente"
}
