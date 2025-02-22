package com.exe.app.controllers;

import com.exe.app.models.PQRS;
import com.exe.app.services.PQRSService;
import com.exe.app.util.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pqrs")
public class PQRSController {

    @Autowired
    private PQRSService pqrsService;

    // Listar todas las PQRS con paginación
    @GetMapping
    public String listarPQRS(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<PQRS> pqrsPage = pqrsService.findAll(page);
        PageRender<PQRS> pageRender = new PageRender<>("/pqrs", pqrsPage);

        model.addAttribute("pqrs", pqrsPage);
        model.addAttribute("page", pageRender);
        model.addAttribute("pqrs", new PQRS()); // Para el formulario de crear PQRS
        model.addAttribute("content", "Lista de PQRS");

        return "pqrs"; // Nombre de la vista que muestra la lista
    }

    // Guardar o crear una nueva PQRS
    @PostMapping("/guardar")
    public String guardarPQRS(@ModelAttribute("pqrs") PQRS pqrs) {
        pqrsService.saveOrUpdatePQRS(pqrs);
        return "redirect:/contacto";
    }

    // Mostrar formulario para editar una PQRS existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        PQRS pqrs = pqrsService.findById(id);
        if (pqrs != null) {
            model.addAttribute("pqrs", pqrs);
            model.addAttribute("content", "Editar PQRS");
            return "pqrs"; // Nombre de la vista del formulario de edición
        }
        return "redirect:/pqrs"; // Redirige si no se encuentra la PQRS
    }

    // Actualizar una PQRS existente
    @PostMapping("/actualizar/{id}")
    public String actualizarPQRS(@PathVariable Long id, @ModelAttribute("pqrs") PQRS pqrs) {
        pqrs.setId(id); // Asegúrate de que el ID se establezca
        pqrsService.saveOrUpdatePQRS(pqrs);
        return "redirect:/pqrs";
    }

    // Eliminar una PQRS por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarPQRS(@PathVariable Long id) {
        pqrsService.deleteById(id);
        return "redirect:/pqrs";
    }
}