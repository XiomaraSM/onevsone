package com.exe.app.repositories;

import com.exe.app.models.AgendaClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaClaseRepository extends JpaRepository<AgendaClase, Long> {
    // Puedes agregar métodos personalizados aquí si necesitas consultas específicas
}
