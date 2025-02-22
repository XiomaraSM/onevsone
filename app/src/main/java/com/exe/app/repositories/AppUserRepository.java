package com.exe.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exe.app.models.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    // Encuentra un usuario por su número de documento
    AppUser findByNumeroDocumento(String numeroDocumento);

    // Encuentra un usuario por su correo electrónico
    AppUser findByEmail(String email);
}