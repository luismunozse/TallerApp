package com.solucionati.taller.controller;

import com.solucionati.taller.model.Modelo;
import com.solucionati.taller.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/modelos")
public class ModeloViewController {

    private final ModeloService modeloService;

    @Autowired
    public ModeloViewController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public String listarModelos(Model model) {
        List<Modelo> modelos = modeloService.getAllModelos();
        model.addAttribute("modelos", modelos);
        model.addAttribute("titulo", "Lista de Modelos");
        return "modelos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("modelo", new Modelo());
        model.addAttribute("titulo", "Nuevo Modelo");
        return "modelos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarModelo(@ModelAttribute Modelo modelo) {
        modeloService.saveModelo(modelo);
        return "redirect:/modelos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Modelo modelo = modeloService.getModeloById(id).orElse(null);
        if (modelo == null) {
            return "redirect:/modelos"; // O mostrar un mensaje de error
        }
        model.addAttribute("modelo", modelo);
        model.addAttribute("titulo", "Editar Modelo");
        return "modelos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarModelo(@PathVariable Long id) {
        modeloService.deleteModelo(id);
        return "redirect:/modelos";
    }
}