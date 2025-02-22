package com.exe.app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exe.app.models.AppUser;
import com.exe.app.models.RegisterDto;
import com.exe.app.repositories.AppUserRepository;
import com.exe.app.util.PageRender;

@Controller
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserRepository appUserRepository;

    // Listar todos los usuarios con paginación
    @GetMapping
    public String listarUsuarios(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 5); // Define elementos por página
        Page<AppUser> usersPage = appUserRepository.findAll(pageRequest); // Obtiene usuarios paginados
        PageRender<AppUser> pageRender = new PageRender<>("/users", usersPage);

        model.addAttribute("users", usersPage);
        model.addAttribute("page", pageRender);
        model.addAttribute("appUser", new AppUser()); // Para el modal de agregar usuario
        model.addAttribute("content", "Lista actualizada de usuarios");

        return "listarUsuarios"; // Nombre de la vista
    }

    // Registrar un nuevo usuario
    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute("registerDto") RegisterDto registerDto, Model model) {
        try {
            // Verificar si el correo ya existe
            if (appUserRepository.findByEmail(registerDto.getEmail()) != null) {
                model.addAttribute("error", "El correo electrónico ya está registrado.");
                return "register";
            }

            // Verificar si el número de documento ya existe
            if (appUserRepository.findByNumeroDocumento(registerDto.getNumeroDocumento()) != null) {
                model.addAttribute("error", "El número de documento ya está registrado.");
                return "register";
            }

            // Crear y guardar el nuevo usuario
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            AppUser newUser = new AppUser();

            newUser.setTipoDocumento(registerDto.getTipoDocumento());
            newUser.setNumeroDocumento(registerDto.getNumeroDocumento());
            newUser.setPrimerNombre(registerDto.getPrimerNombre());
            newUser.setSegundoNombre(registerDto.getSegundoNombre());
            newUser.setPrimerApellido(registerDto.getPrimerApellido());
            newUser.setSegundoApellido(registerDto.getSegundoApellido());
            newUser.setEmail(registerDto.getEmail());
            newUser.setCelular(registerDto.getCelular());
            newUser.setLocalidadBogota(registerDto.getLocalidadBogota());
            newUser.setBarrio(registerDto.getBarrio());
            newUser.setDireccion(registerDto.getDireccion());
            newUser.setRole(AppUser.UserRole.USUARIO);
            newUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));

            appUserRepository.save(newUser);

            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success", "Usuario registrado con éxito.");
        } catch (Exception ex) {
            model.addAttribute("error", "Error al registrar el usuario: " + ex.getMessage());
        }
        return "register";
    }

    // Guardar un usuario desde el listado
    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute("appUser") AppUser appUser, Model model) {
        try {
            if (appUserRepository.findByEmail(appUser.getEmail()) != null) {
                model.addAttribute("error", "El correo electrónico ya está en uso.");
                return "listarUsuarios";
            }

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (appUser.getPassword() != null && !appUser.getPassword().isEmpty()) {
                appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
            }

            appUserRepository.save(appUser);
            model.addAttribute("success", "Usuario guardado con éxito.");
        } catch (Exception ex) {
            model.addAttribute("error", "Error al guardar el usuario: " + ex.getMessage());
        }
        return "redirect:/users";
    }

    // Mostrar formulario para editar un usuario
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Optional<AppUser> userOpt = appUserRepository.findById(id);
        if (userOpt.isPresent()) {
            model.addAttribute("appUser", userOpt.get());
            model.addAttribute("content", "Editar usuario");
            return "admin"; // Nombre de la plantilla para edición
        }
        model.addAttribute("error", "Usuario no encontrado.");
        return "redirect:/users";
    }

    // Actualizar un usuario existente
@PostMapping("/actualizar")
public String actualizarUsuario(@ModelAttribute("appUser") AppUser appUser, Model model) {
    try {
        // Buscar el usuario existente
        Optional<AppUser> existingUserOpt = appUserRepository.findById(appUser.getId());
        if (existingUserOpt.isPresent()) {
            AppUser existingUser = existingUserOpt.get();

            // Actualizar los campos necesarios
            existingUser.setTipoDocumento(appUser.getTipoDocumento());
            existingUser.setNumeroDocumento(appUser.getNumeroDocumento());
            existingUser.setPrimerNombre(appUser.getPrimerNombre());
            existingUser.setSegundoNombre(appUser.getSegundoNombre());
            existingUser.setPrimerApellido(appUser.getPrimerApellido());
            existingUser.setSegundoApellido(appUser.getSegundoApellido());
            existingUser.setEmail(appUser.getEmail());
            existingUser.setCelular(appUser.getCelular());
            existingUser.setLocalidadBogota(appUser.getLocalidadBogota());
            existingUser.setBarrio(appUser.getBarrio());
            existingUser.setDireccion(appUser.getDireccion());
            existingUser.setRole(appUser.getRole());

            // Si se proporciona una nueva contraseña, codificarla
            if (appUser.getPassword() != null && !appUser.getPassword().isEmpty()) {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                existingUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
            }

            // Guardar los cambios
            appUserRepository.save(existingUser);
            model.addAttribute("success", "Usuario actualizado con éxito.");
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
        }
    } catch (Exception ex) {
        model.addAttribute("error", "Error al actualizar el usuario: " + ex.getMessage());
    }
    return "redirect:/users";
}


    // Eliminar un usuario por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id, Model model) {
        if (appUserRepository.existsById(id)) {
            appUserRepository.deleteById(id);
            model.addAttribute("success", "Usuario eliminado con éxito.");
        } else {
            model.addAttribute("error", "El usuario no existe.");
        }
        return "redirect:/users";
    }
}
