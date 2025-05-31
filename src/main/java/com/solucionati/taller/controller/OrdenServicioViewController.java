package com.solucionati.taller.controller;

import com.solucionati.taller.model.OrdenServicio;
import com.solucionati.taller.service.OrdenServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ordenes")
public class OrdenServicioViewController {

    private final OrdenServicioService ordenServicioService;

    @Autowired
    public OrdenServicioViewController(OrdenServicioService ordenServicioService) {
        this.ordenServicioService = ordenServicioService;
    }

    @GetMapping
    public String listarOrdenes(Model model) {
        List<OrdenServicio> ordenes = ordenServicioService.getAllOrdenesServicio();
        model.addAttribute("ordenes", ordenes);
        model.addAttribute("titulo", "Lista de Órdenes de Servicio");
        return "ordenes/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("orden", new OrdenServicio());
        model.addAttribute("titulo", "Nueva Orden de Servicio");
        return "ordenes/formulario";
    }

    @PostMapping("/guardar")
    public String guardarOrden(@ModelAttribute OrdenServicio orden) {
        ordenServicioService.saveOrdenServicio(orden);
        return "redirect:/ordenes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        OrdenServicio orden = ordenServicioService.getOrdenServicioById(id).orElse(null);
        if (orden == null) {
            return "redirect:/ordenes"; // O mostrar un mensaje de error
        }
        model.addAttribute("orden", orden);
        model.addAttribute("titulo", "Editar Orden de Servicio");
        return "ordenes/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarOrden(@PathVariable Long id) {
        ordenServicioService.deleteOrdenServicio(id);
        return "redirect:/ordenes";
    }
}