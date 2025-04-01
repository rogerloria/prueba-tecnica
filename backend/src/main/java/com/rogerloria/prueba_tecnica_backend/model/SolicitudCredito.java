package com.rogerloria.prueba_tecnica_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "solicitudes")
public class SolicitudCredito {
    @Id
    private String id;
    private String usuarioId;
    private LocalDate fechaSolicitud;
    private String estado; // TODO: cambiar al tipo enum "aprobada", "rechazada", "pendiente"

    public SolicitudCredito() {}

    public SolicitudCredito(String id, String usuarioId, LocalDate fechaSolicitud, String estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuario(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
