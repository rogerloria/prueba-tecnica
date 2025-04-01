package com.rogerloria.prueba_tecnica_backend.service;

import com.rogerloria.prueba_tecnica_backend.model.SolicitudCredito;
import com.rogerloria.prueba_tecnica_backend.repository.SolicitudCreditoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SolicitudCreditoService {
    private static final Logger logger = LoggerFactory.getLogger(SolicitudCreditoService.class); // Logs
    private final SolicitudCreditoRepository solicitudCreditoRepository; // Inyecta el repositorio

    @Autowired
    public SolicitudCreditoService(SolicitudCreditoRepository solicitudCreditoRepository) {
        this.solicitudCreditoRepository = solicitudCreditoRepository;
    }

    public List<SolicitudCredito> obtenerSolicitudes() {
        logger.info("Obteniendo todas las solicitudes de crédito");
        return solicitudCreditoRepository.findAll();
    }

    public Optional<SolicitudCredito> obtenerSolicitudPorId(String id) {
        logger.info("Buscando solicitud de crédito con ID: {}", id);
        return solicitudCreditoRepository.findById(id);
    }

    public SolicitudCredito guardarSolicitud(SolicitudCredito solicitud) {
        logger.info("Guardando solicitud de crédito: {}", solicitud);
        return solicitudCreditoRepository.save(solicitud);
    }

    public void eliminarSolicitud(String id) {
        logger.info("Intentando eliminar solicitud de crédito con ID: {}", id);
        if (!solicitudCreditoRepository.existsById(id)) {
            logger.warn("No existe una solicitud con identificador: {} ", id);
            throw new NoSuchElementException("La solicitud que intentas eliminar no existe");
        }
        solicitudCreditoRepository.deleteById(id);
        logger.info("La solicitud de crédito con identificador {} ha sido eliminada", id);
    }
}
