package com.exe.app.controllers;

import com.exe.app.models.AgendaClase;
import com.exe.app.services.AgendaClaseService;
import com.exe.app.util.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agendaClase")
public class AgendaClaseController {

    @Autowired
    private AgendaClaseService agendaClaseService;

    // Listar todas las clases agendadas con paginación
    @GetMapping
    public String listarAgendaClases(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 5); // Define el tamaño de página como en PersonaController
        Page<AgendaClase> agendaClasePage = agendaClaseService.findAll(pageRequest); // Cambia el método para que use paginación
        PageRender<AgendaClase> pageRender = new PageRender<>("/agendaClase", agendaClasePage);

        model.addAttribute("agendaClases", agendaClasePage);
        model.addAttribute("page", pageRender);
        model.addAttribute("agendaClase", new AgendaClase()); // Para el formulario de agendar clase
        model.addAttribute("content", "Lista de clases agendadas");

        return "agendaClase"; // Nombre de la vista
    }

    // Mostrar formulario para crear una nueva clase
    @GetMapping("/agendaClase")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("agendaClase", new AgendaClase()); // Crear una nueva instancia para el formulario
        return "agendaClase"; // Nombre del archivo HTML con el formulario
    }

    // Guardar o agendar una nueva clase y redirigir a la vista de agenda de clases
    @PostMapping("/guardar")
    public String guardarAgendaClase(@ModelAttribute("agendaClase") AgendaClase agendaClase) {
        agendaClaseService.saveOrUpdateAgendaClase(agendaClase);
        return "redirect:/agendaClase"; // Redirige a la lista de clases agendadas después de guardar
    }

    // Guardar o agendar una nueva clase y redirigir a la vista de contacto
    @PostMapping("/guardarYRedirigir")
    public String guardarYRedirigir(@ModelAttribute("agendaClase") AgendaClase agendaClase) {
        agendaClaseService.saveOrUpdateAgendaClase(agendaClase);
        return "redirect:/contacto"; // Redirige a la vista de contacto después de guardar
    }

    // Mostrar formulario para editar una clase agendada
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        AgendaClase agendaClase = agendaClaseService.findById(id);
        if (agendaClase != null) {
            model.addAttribute("agendaClase", agendaClase);
            model.addAttribute("content", "Editar clase agendada");
            return "agendaClase"; // Nombre de la vista de edición
        }
        return "redirect:/agendaClase"; // Redirige si no se encuentra la clase
    }

    // Actualizar una clase agendada
    @PostMapping("/actualizar/{id}")
    public String actualizarAgendaClase(@PathVariable("id") Long id, @ModelAttribute("agendaClase") AgendaClase agendaClase) {
        agendaClase.setId(id); // Asegúrate de que el ID se establezca
        agendaClaseService.saveOrUpdateAgendaClase(agendaClase);
        return "redirect:/agendaClase";
    }

    // Eliminar una clase agendada por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarAgendaClase(@PathVariable("id") Long id) {
        agendaClaseService.deleteById(id);
        return "redirect:/agendaClase";
    }
}
