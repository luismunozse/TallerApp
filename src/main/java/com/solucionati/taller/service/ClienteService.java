package com.solucionati.taller.service;

import com.solucionati.taller.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> getAllClientes();
    Optional<Cliente> getClienteById(Long id);
    Cliente saveCliente(Cliente cliente);
    void deleteCliente(Long id);
}
