package com.solucionati.taller.controller;

import com.solucionati.taller.model.Marca;
import com.solucionati.taller.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/marcas")
public class MarcaViewController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaViewController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public String listarMarcas(Model model) {
        List<Marca> marcas = marcaService.getAllMarcas();
        model.addAttribute("marcas", marcas);
        model.addAttribute("titulo", "Lista de Marcas");
        return "marcas/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("marca", new Marca());
        model.addAttribute("titulo", "Nueva Marca");
        return "marcas/formulario";
    }

    @PostMapping("/guardar")
    public String guardarMarca(@ModelAttribute Marca marca) {
        marcaService.saveMarca(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Marca marca = marcaService.getMarcaById(id).orElse(null);
        if (marca == null) {
            return "redirect:/marcas"; // O mostrar un mensaje de error
        }
        model.addAttribute("marca", marca);
        model.addAttribute("titulo", "Editar Marca");
        return "marcas/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMarca(@PathVariable Long id) {
        marcaService.deleteMarca(id);
        return "redirect:/marcas";
    }
}