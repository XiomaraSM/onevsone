package com.exe.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exe.app.models.PagosParticipantes;
import com.exe.app.repositories.PagosParticipantesRepository;

import java.util.Optional;

@Service
public class PagosParticipantesService {
    
    @Autowired
    private PagosParticipantesRepository pagosParticipantesRepository;

    // Obtener todos los pagos de participantes con paginación
    public Page<PagosParticipantes> findAll(Pageable pageable) {
        return pagosParticipantesRepository.findAll(pageable);
    }

    // Guardar o actualizar un pago de participante
    public PagosParticipantes saveOrUpdatePagosParticipantes(PagosParticipantes pagosParticipantes) {
        return pagosParticipantesRepository.save(pagosParticipantes);
    }

    // Obtener un pago de participante por ID
    public Optional<PagosParticipantes> getPagosParticipantesById(Long id) {
        return pagosParticipantesRepository.findById(id);
    }

    // Eliminar un pago de participante por ID
    public void deletePagosParticipantesById(Long id) {
        pagosParticipantesRepository.deleteById(id);
    }
}
