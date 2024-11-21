package com.proyecto.social.proyectosocial.repository;

import com.proyecto.social.proyectosocial.modelo.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    // JpaRepository ya incluye los métodos CRUD
}

