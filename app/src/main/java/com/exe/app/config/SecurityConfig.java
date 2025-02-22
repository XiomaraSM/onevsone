package com.exe.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/contacto", "/quienesSomos", "/convenios").permitAll()
                .requestMatchers("/bannerPromos.png", "/barriosRondaLogo.png", "/break_clase.jpg", "/break_presentacion.jpg", 
                    "/Breakdance.jpeg", "/breakdance.jpeg", "/BreakDance.jpg", "/Capoeira.jpg", "/capoeiraLogo.png", "/colectivoSorora.png", "/combate.jpeg", "/corpocurareLogo.png", 
                    "/danzaCircundante.png", "/Deportes_combate.jpg", "/dragonesLogo.png", "/entrenamiento.jpeg", 
                    "/Entrenamiento.jpg", "/impulsoLocal.png", "/JumpRope.jpg", "/Logo.png", "/microempresaLocal.png", "/miMaestroHH.png", "/Nunchakus.jpg", 
                    "/onevsoneBanner.png", "/presentacion.png", "/promoDiciembre.png", "/retoMes.png", "/sororaLogo.png").permitAll()
                .requestMatchers("/forgot-password", "/register", "/login", "/logout").permitAll()
                .requestMatchers("/admin").hasAnyRole("ADMIN", "ENTRENADOR")
                .requestMatchers("/usuarios").hasRole("USUARIO")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form 
                .loginPage("/login")
                .successHandler(new CustomAuthenticationSuccessHandler()) // Usa el CustomAuthenticationSuccessHandler
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
            )
            .logout(config -> config.logoutSuccessUrl("/"))
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
