package com.exe.app.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Verifica los roles del usuario autenticado
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();
            if ("ROLE_ADMIN".equals(role) || "ROLE_ENTRENADOR".equals(role)) {
                response.sendRedirect("/admin");
                return;
            } else if ("ROLE_USUARIO".equals(role)) {
                response.sendRedirect("/usuarios");
                return;
            }
        }
        // Por defecto, redirige a la página de inicio
        response.sendRedirect("/");
    }
}
