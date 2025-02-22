package com.exe.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exe.app.models.Seguimiento;
import com.exe.app.repositories.SeguimientoRepository;

import java.util.Optional;

@Service
public class SeguimientoService {

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    // Método para obtener todos los seguimientos
    public Page<Seguimiento> findAll(Pageable pageable) {
        return seguimientoRepository.findAll(pageable);
    }

    // Método para obtener un seguimiento por su id
    public Optional<Seguimiento> obtenerPorId(Long id) {
        return seguimientoRepository.findById(id);
    }

    // Método para guardar un nuevo seguimiento
    public Seguimiento guardar(Seguimiento seguimiento) {
        return seguimientoRepository.save(seguimiento);
    }

    // Método para actualizar un seguimiento existente
    public Seguimiento actualizar(Seguimiento seguimiento) {
        return seguimientoRepository.save(seguimiento);
    }

    // Método para eliminar un seguimiento
    public void eliminar(Long id) {
        seguimientoRepository.deleteById(id);
    }

}
