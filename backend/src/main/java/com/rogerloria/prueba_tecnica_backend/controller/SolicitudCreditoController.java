package com.rogerloria.prueba_tecnica_backend.controller;

import com.rogerloria.prueba_tecnica_backend.model.SolicitudCredito;
import com.rogerloria.prueba_tecnica_backend.service.SolicitudCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudCreditoController {

    private final SolicitudCreditoService solicitudCreditoService;

    @Autowired
    public SolicitudCreditoController(SolicitudCreditoService solicitudCreditoService) {
        this.solicitudCreditoService = solicitudCreditoService;
    }

    @GetMapping
    public List<SolicitudCredito> obtenerSolicitudes() {
        return solicitudCreditoService.obtenerSolicitudes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudCredito> obtenerSolicitudPorId(@PathVariable String id) {
        Optional<SolicitudCredito> solicitud = solicitudCreditoService.obtenerSolicitudPorId(id);
        return solicitud.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SolicitudCredito> guardarSolicitud(@RequestBody SolicitudCredito solicitud) {
        SolicitudCredito solicitudGuardada = solicitudCreditoService.guardarSolicitud(solicitud);
        return ResponseEntity.ok(solicitudGuardada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable String id) {
        solicitudCreditoService.eliminarSolicitud(id);
        return ResponseEntity.noContent().build();
    }
}
