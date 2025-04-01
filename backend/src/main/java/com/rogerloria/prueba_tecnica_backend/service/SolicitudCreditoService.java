package com.rogerloria.prueba_tecnica_backend.service;

import com.rogerloria.prueba_tecnica_backend.model.SolicitudCredito;
import com.rogerloria.prueba_tecnica_backend.repository.SolicitudCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudCreditoService {
    private final SolicitudCreditoRepository solicitudCreditoRepository; // Inyecta el repositorio

    @Autowired
    public SolicitudCreditoService(SolicitudCreditoRepository solicitudCreditoRepository) {
        this.solicitudCreditoRepository = solicitudCreditoRepository;
    }

    public List<SolicitudCredito> obtenerSolicitudes() {
        return solicitudCreditoRepository.findAll();
    }

    public Optional<SolicitudCredito> obtenerSolicitudPorId(String id) {
        return solicitudCreditoRepository.findById(id);
    }

    public SolicitudCredito guardarSolicitud(SolicitudCredito solicitud) {
        return solicitudCreditoRepository.save(solicitud);
    }

    public void eliminarSolicitud(String id) {
        solicitudCreditoRepository.deleteById(id);
    }
}
