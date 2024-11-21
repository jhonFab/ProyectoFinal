package com.proyecto.social.proyectosocial.repository;

import com.proyecto.social.proyectosocial.modelo.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Integer> {


}
