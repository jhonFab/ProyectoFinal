package com.proyecto.social.proyectosocial.repository;

import com.proyecto.social.proyectosocial.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // JpaRepository ya proporciona los métodos básicos CRUD
}
