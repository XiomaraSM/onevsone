package com.exe.app.controllers;


import com.exe.app.models.Seguimiento;
import com.exe.app.services.SeguimientoService;
import com.exe.app.util.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/seguimientos")
public class SeguimientoController {

    @Autowired
    private SeguimientoService seguimientoService;

    // Listar todos los seguimientos con paginación
    @GetMapping
    public String listarSeguimientos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 5); // Definir cantidad de elementos por página
        Page<Seguimiento> seguimientosPage = seguimientoService.findAll(pageRequest); // Obtener seguimientos paginados
        PageRender<Seguimiento> pageRender = new PageRender<>("/seguimientos", seguimientosPage);

        model.addAttribute("seguimientos", seguimientosPage);
        model.addAttribute("page", pageRender); // Renderizar la paginación en la vista
        model.addAttribute("seguimiento", new Seguimiento()); // Para el formulario de agregar seguimiento
        model.addAttribute("content", "Lista actualizada de seguimientos");

        return "listarSeguimientos"; // Nombre de la vista
    }

    // Guardar un nuevo seguimiento y redirigir a la lista de seguimientos
    @PostMapping("/guardar")
    public String guardarSeguimiento(@ModelAttribute("seguimiento") Seguimiento seguimiento) {
        seguimientoService.guardar(seguimiento); // Guardamos el seguimiento
        return "redirect:/seguimientos"; // Redirige nuevamente a la lista de seguimientos
    }

    // Mostrar formulario para editar un seguimiento existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<Seguimiento> seguimientoOpt = seguimientoService.obtenerPorId(id);
        if (seguimientoOpt.isPresent()) {
            model.addAttribute("seguimiento", seguimientoOpt.get());
            model.addAttribute("content", "Editar seguimiento");
            return "listarSeguimientos"; // Asegúrate de que este sea el nombre correcto de la plantilla para editar
        }
        return "redirect:/seguimientos"; // Redirige si no se encuentra el seguimiento
    }

    // Actualizar un seguimiento existente
    @PostMapping("/actualizar/{id}")
    public String actualizarSeguimiento(@PathVariable Long id, @ModelAttribute("seguimiento") Seguimiento seguimiento) {
        seguimiento.setId(id); // Establecer el ID
        seguimientoService.actualizar(seguimiento);
        return "redirect:/seguimientos";
    }

    // Eliminar un seguimiento por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarSeguimiento(@PathVariable Long id) {
        seguimientoService.eliminar(id);
        return "redirect:/seguimientos";
    }
}
