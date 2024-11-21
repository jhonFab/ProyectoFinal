package com.proyecto.social.proyectosocial.repository;

import com.proyecto.social.proyectosocial.modelo.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
    // JpaRepository ya proporciona los métodos CRUD básicos
}

