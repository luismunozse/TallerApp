package com.solucionati.taller.service;

import com.solucionati.taller.model.OrdenServicio;

import java.util.List;
import java.util.Optional;

public interface OrdenServicioService {

    List<OrdenServicio> getAllOrdenesServicio();
    Optional<OrdenServicio> getOrdenServicioById(Long id);
    OrdenServicio saveOrdenServicio(OrdenServicio ordenServicio);
    void deleteOrdenServicio(Long id);
}
