package com.solucionati.taller.service;

import com.solucionati.taller.model.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {

    List<Marca> getAllMarcas();
    Optional<Marca> getMarcaById(Long id);
    Marca saveMarca(Marca marca);
    void deleteMarca(Long id);
}
