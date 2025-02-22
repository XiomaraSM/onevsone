package com.exe.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "", "/" })
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Nombre de tu archivo HTML en `src/main/resources/templates`
    }

    @GetMapping("/quienesSomos")
    public String quienesSomos() {
        // Retorna la vista que está en templates/quienes-somos.html
        return "quienesSomos";
    }

    @GetMapping("/convenios")
    public String laborSocial() {
        // Retorna la vista que está en templates/labor-social.html
        return "convenios";
    }

    @GetMapping("/contacto")
    public String contacto() {
        // Retorna la vista que está en templates/contacto.html
        return "contacto";
    }

    // Administrador
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    // usuarios
    @GetMapping("/usuarios")
    public String usuarios() {
        return "usuarios";
    }

    // usuarios clases
    @GetMapping("/claseUsuario")
    public String claseUsuario() {
        return "claseUsuario";
    }

    // usuarios pqrs
    @GetMapping("/pqrsUsuario")
    public String pqrsUsuario() {
        return "pqrsUsuario";
    }

    // usuarios compras
    @GetMapping("/compras")
    public String compras() {
        return "compras";
    }

}
