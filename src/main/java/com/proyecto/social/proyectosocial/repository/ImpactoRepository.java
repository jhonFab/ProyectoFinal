package com.proyecto.social.proyectosocial.repository;

import com.proyecto.social.proyectosocial.modelo.Impacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpactoRepository extends JpaRepository<Impacto, Integer> {
    // JpaRepository incluye métodos básicos CRUD
}
