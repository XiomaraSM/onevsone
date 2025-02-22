package com.exe.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.exe.app.models.PQRS;
import com.exe.app.repositories.PQRSRepository;

@Service
public class PQRSService {

    @Autowired
    private PQRSRepository pqrsRepository;

    // Encontrar todas las PQRS con paginación
    public Page<PQRS> findAll(int page) {
        return pqrsRepository.findAll(PageRequest.of(page, 10)); // 10 elementos por página
    }

    // Guardar o actualizar una PQRS
    public void saveOrUpdatePQRS(PQRS pqrs) {
        pqrsRepository.save(pqrs);
    }

    // Encontrar una PQRS por ID
    public PQRS findById(Long id) {
        return pqrsRepository.findById(id).orElse(null);
    }

    // Eliminar una PQRS por ID
    public void deleteById(Long id) {
        pqrsRepository.deleteById(id);
    }
}
