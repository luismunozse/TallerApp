package com.solucionati.taller.service;

import com.solucionati.taller.model.Modelo;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ModeloService {

    List<Modelo> getAllModelos();
    Optional<Modelo> getModeloById(Long id);
    Modelo saveModelo(Modelo modelo);
    void deleteModelo(Long id);
}
