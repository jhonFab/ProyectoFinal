package com.proyecto.social.proyectosocial.servicio;

import com.proyecto.social.proyectosocial.modelo.Impacto;
import com.proyecto.social.proyectosocial.repository.ImpactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpactoServicio {

    @Autowired
    private ImpactoRepository impactoRepository;

    // Obtener todos los registros de impacto
    public List<Impacto> obtenerTodos() {
        return impactoRepository.findAll();
    }

    // Obtener un registro de impacto por ID
    public Optional<Impacto> obtenerPorId(int id) {
        return impactoRepository.findById(id);
    }

    // Guardar o actualizar un registro de impacto
    public Impacto guardar(Impacto impacto) {
        return impactoRepository.save(impacto);
    }

    // Eliminar un registro de impacto por ID
    public void eliminar(int id) {
        impactoRepository.deleteById(id);
    }
}
