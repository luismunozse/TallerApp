package com.solucionati.taller.controller;

import com.solucionati.taller.model.Marca;
import com.solucionati.taller.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public List<Marca> getAllMarcas() {
        return marcaService.getAllMarcas();
    }

    @GetMapping("/{id}")
    public Optional<Marca> getMarcaById(@PathVariable Long id) {
        return marcaService.getMarcaById(id);
    }

    @PostMapping
    public Marca saveMarca(@RequestBody Marca marca) {
        return marcaService.saveMarca(marca);
    }

    @DeleteMapping("/{id}")
    public void deleteMarca(@PathVariable Long id) {
        marcaService.deleteMarca(id);
    }

}
