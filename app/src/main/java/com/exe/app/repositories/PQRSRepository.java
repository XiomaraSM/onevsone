package com.exe.app.repositories;
import com.exe.app.models.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PQRSRepository extends JpaRepository<PQRS, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}