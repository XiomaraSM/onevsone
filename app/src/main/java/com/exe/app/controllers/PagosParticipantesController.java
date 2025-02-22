package com.exe.app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exe.app.models.PagosParticipantes;
import com.exe.app.services.PagosParticipantesService;
import com.exe.app.util.PageRender;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping("/pagos")
public class PagosParticipantesController {
    
    @Autowired
    private PagosParticipantesService pagosParticipantesService;

    // Listar todos los pagos con paginación
    @GetMapping
    public String listarPagos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 5); // Definimos la cantidad de elementos por página
        Page<PagosParticipantes> pagosPage = pagosParticipantesService.findAll(pageRequest); // Obtener los pagos paginados
        PageRender<PagosParticipantes> pageRender = new PageRender<>("/pagos", pagosPage);

        model.addAttribute("pagos", pagosPage);
        model.addAttribute("page", pageRender); // Renderizar la paginación en la vista
        model.addAttribute("pago", new PagosParticipantes()); // Para el modal de agregar pago
        model.addAttribute("content", "Lista actualizada de pagos de participantes");
        
        return "listarPagos"; // Nombre de la vista
    }

    // Guardar un nuevo pago
    @PostMapping("/guardar")
    public String guardarPago(@ModelAttribute("pago") PagosParticipantes pago) {
        pagosParticipantesService.saveOrUpdatePagosParticipantes(pago);
        return "redirect:/pagos";
    }

    // Mostrar formulario para editar un pago existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<PagosParticipantes> pagoOpt = pagosParticipantesService.getPagosParticipantesById(id);
        if (pagoOpt.isPresent()) {
            model.addAttribute("pago", pagoOpt.get());
            model.addAttribute("content", "Editar pago de participante");
            return "admin"; // Asegúrate de que "admin" sea el nombre correcto de la plantilla principal
        }
        return "redirect:/pagos"; // Redirige si no se encuentra el pago
    }

    // Actualizar un pago existente
    @PostMapping("/actualizar/{id}")
    public String actualizarPago(@PathVariable Long id, @ModelAttribute("pago") PagosParticipantes pago) {
        pago.setId(id); // Asegúrate de que el ID se establezca
        pagosParticipantesService.saveOrUpdatePagosParticipantes(pago);
        return "redirect:/pagos";
    }

    // Eliminar un pago por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarPago(@PathVariable Long id) {
        pagosParticipantesService.deletePagosParticipantesById(id);
        return "redirect:/pagos";
    }
}
