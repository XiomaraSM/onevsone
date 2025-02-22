package com.exe.app.repositories;

import com.exe.app.models.PagosParticipantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagosParticipantesRepository extends JpaRepository<PagosParticipantes, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
