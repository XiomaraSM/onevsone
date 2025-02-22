package com.exe.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.exe.app.models.AppUser;
import com.exe.app.models.RegisterDto;
import com.exe.app.repositories.AppUserRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AppUserRepository repo;


    @GetMapping("/forgot-password")
    public String forgotPassword(Model model) {
        // Añade un objeto para los datos de recuperación
        model.addAttribute("email", "");
        model.addAttribute("numeroDocumento", "");
        return "forgot-password"; // Página con el formulario para recuperación
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(
        @ModelAttribute("email") String email,
        @ModelAttribute("numeroDocumento") String numeroDocumento,
        Model model) {

        // Validar si el usuario existe con el correo y número de documento
        AppUser user = repo.findByEmail(email);

        if (user == null || !user.getNumeroDocumento().equals(numeroDocumento)) {
            model.addAttribute("error", "Los datos no coinciden con un usuario registrado.");
            return "forgot-password";
        }

        // Pasa los datos del usuario para el cambio de contraseña
        model.addAttribute("userId", user.getId());
        return "reset-password"; // Página para cambiar la contraseña
    }

    @PostMapping("/reset-password")
    public String resetPassword(
        @ModelAttribute("userId") Integer userId,
        @ModelAttribute("newPassword") String newPassword,
        @ModelAttribute("confirmPassword") String confirmPassword,
        Model model) {

        // Validar contraseñas
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden.");
            return "reset-password";
        }

        // Actualizar la contraseña en la base de datos
        AppUser user = repo.findById(userId).orElse(null);
        if (user == null) {
            model.addAttribute("error", "Usuario no encontrado.");
            return "reset-password";
        }

        var bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
        repo.save(user);

        model.addAttribute("success", "Contraseña actualizada con éxito.");
        return "login"; // Redirigir al formulario de inicio de sesión
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("registerDto", registerDto);
        model.addAttribute("success", false);
        return "register";
    }
    
    @PostMapping("/register")
    public String register(
        Model model,
        @Valid @ModelAttribute("registerDto") RegisterDto registerDto,
        BindingResult result) {

        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(new FieldError("registerDto", "confirmPassword", "Las contraseñas no coinciden"));
        }

        AppUser appUser = repo.findByEmail(registerDto.getEmail());
        if (appUser != null) {
            result.addError(new FieldError("registerDto", "email", "La dirección de correo electrónico ya está en uso"));
        }

        if (result.hasErrors()) {
            return "register";
        }

        try {
            var bCryptPasswordEncoder = new BCryptPasswordEncoder();

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
            newUser.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));

            repo.save(newUser); 

            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success", true);
        } catch (Exception ex) {
            result.addError(new FieldError("registerDto", "primerNombre", ex.getMessage()));
        }
        return "register";
    }
}
