package com.exe.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exe.app.models.AgendaClase;
import com.exe.app.repositories.AgendaClaseRepository;

@Service
public class AgendaClaseService {

    @Autowired
    private AgendaClaseRepository agendaClaseRepository;

    // Listar todas las clases agendadas con paginación
    @Transactional(readOnly = true)
    public Page<AgendaClase> findAll(Pageable pageable) {
        return agendaClaseRepository.findAll(pageable);
    }

    // Encontrar una clase agendada por ID
    @Transactional(readOnly = true)
    public AgendaClase findById(Long id) {
        return agendaClaseRepository.findById(id).orElse(null);
    }

    // Guardar o actualizar una clase agendada
    @Transactional
    public AgendaClase saveOrUpdateAgendaClase(AgendaClase agendaClase) {
        return agendaClaseRepository.save(agendaClase);
    }

    // Eliminar una clase agendada por ID
    @Transactional
    public void deleteById(Long id) {
        agendaClaseRepository.deleteById(id);
    }
}
