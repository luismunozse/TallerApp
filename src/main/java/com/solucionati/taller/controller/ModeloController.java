package com.solucionati.taller.controller;

import com.solucionati.taller.model.Modelo;
import com.solucionati.taller.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    private final ModeloService modeloService;

    @Autowired
    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public List<Modelo> getAllModelos() {
        return modeloService.getAllModelos();
    }

    @GetMapping("/{id}")
    public Optional<Modelo> getModeloById(@PathVariable Long id) {
        return modeloService.getModeloById(id);
    }

    @PostMapping
    public Modelo saveModelo(@RequestBody Modelo modelo) {
        return modeloService.saveModelo(modelo);
    }

    @DeleteMapping("/{id}")
    public void deleteModelo(@PathVariable Long id) {
        modeloService.deleteModelo(id);
    }
}
