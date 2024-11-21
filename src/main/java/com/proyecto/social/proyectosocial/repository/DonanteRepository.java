package com.proyecto.social.proyectosocial.repository;

import com.proyecto.social.proyectosocial.modelo.Donante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonanteRepository extends JpaRepository<Donante, Integer> {
    // JpaRepository ya tiene todos los métodos básicos para CRUD.
}
