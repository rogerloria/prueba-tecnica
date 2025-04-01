package com.rogerloria.prueba_tecnica_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "usuario")
public class Usuario {
    @Id
    private String id;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String tipoIdentificacion;
    private String departamento;
    private String municipio;
    private String direccion;
    private Double ingresosMensuales;
}
