package com.proyecto.social.proyectosocial.servicio;

import com.proyecto.social.proyectosocial.modelo.Proyecto;
import com.proyecto.social.proyectosocial.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServicio {

    @Autowired
    private ProyectoRepository proyectoRepository;

    // Obtener todos los proyectos
    public List<Proyecto> obtenerTodos() {
        return proyectoRepository.findAll();
    }

    // Obtener un proyecto por ID
    public Optional<Proyecto> obtenerPorId(int id) {
        return proyectoRepository.findById(id);
    }

    // Guardar o actualizar un proyecto
    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    // Eliminar un proyecto por ID
    public void eliminar(int id) {
        proyectoRepository.deleteById(id);
    }
}
