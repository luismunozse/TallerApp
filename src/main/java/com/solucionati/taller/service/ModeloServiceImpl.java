package com.solucionati.taller.service;

import com.solucionati.taller.model.Modelo;
import com.solucionati.taller.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloServiceImpl implements ModeloService{

    private final ModeloRepository modeloRepository;

    @Autowired
    public ModeloServiceImpl(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    @Override
    public List<Modelo> getAllModelos() {
        return modeloRepository.findAll();
    }

    @Override
    public Optional<Modelo> getModeloById(Long id) {
        return modeloRepository.findById(id);
    }

    @Override
    public Modelo saveModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    @Override
    public void deleteModelo(Long id) {
        modeloRepository.deleteById(id);
    }
}
