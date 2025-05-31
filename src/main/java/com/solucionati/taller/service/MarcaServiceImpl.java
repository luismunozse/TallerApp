package com.solucionati.taller.service;

import com.solucionati.taller.model.Marca;
import com.solucionati.taller.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService{

    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaServiceImpl(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<Marca> getMarcaById(Long id) {
        return marcaRepository.findById(id);
    }

    @Override
    public Marca saveMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public void deleteMarca(Long id) {
        marcaRepository.deleteById(id);
    }
}
