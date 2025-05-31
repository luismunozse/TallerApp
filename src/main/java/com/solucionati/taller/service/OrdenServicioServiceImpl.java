package com.solucionati.taller.service;

import com.solucionati.taller.model.OrdenServicio;
import com.solucionati.taller.repository.OrdenServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenServicioServiceImpl implements OrdenServicioService{

    private final OrdenServicioRepository ordenServicioRepository;

    @Autowired
    public OrdenServicioServiceImpl(OrdenServicioRepository ordenServicioRepository) {
        this.ordenServicioRepository = ordenServicioRepository;
    }

    @Override
    public List<OrdenServicio> getAllOrdenesServicio() {
        return ordenServicioRepository.findAll();
    }

    @Override
    public Optional<OrdenServicio> getOrdenServicioById(Long id) {
        return ordenServicioRepository.findById(id);
    }

    @Override
    public OrdenServicio saveOrdenServicio(OrdenServicio ordenServicio) {
        return ordenServicioRepository.save(ordenServicio);
    }

    @Override
    public void deleteOrdenServicio(Long id) {
        ordenServicioRepository.deleteById(id);
    }
}
