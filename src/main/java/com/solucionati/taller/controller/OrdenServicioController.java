package com.solucionati.taller.controller;

import com.solucionati.taller.model.OrdenServicio;
import com.solucionati.taller.service.OrdenServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordenes-servicio")
public class OrdenServicioController {

    private final OrdenServicioService ordenServicioService;

    @Autowired
    public OrdenServicioController(OrdenServicioService ordenServicioService) {
        this.ordenServicioService = ordenServicioService;
    }

    @GetMapping
    public List<OrdenServicio> getAllOrdenesServicio() {
        return ordenServicioService.getAllOrdenesServicio();
    }

    @GetMapping("/{id}")
    public Optional<OrdenServicio> getOrdenServicioById(@PathVariable Long id) {
        return ordenServicioService.getOrdenServicioById(id);
    }

    @PostMapping
    public OrdenServicio saveOrdenServicio(@RequestBody OrdenServicio ordenServicio) {
        return ordenServicioService.saveOrdenServicio(ordenServicio);
    }

    @DeleteMapping("/{id}")
    public void deleteOrdenServicio(@PathVariable Long id) {
        ordenServicioService.deleteOrdenServicio(id);
    }
}
