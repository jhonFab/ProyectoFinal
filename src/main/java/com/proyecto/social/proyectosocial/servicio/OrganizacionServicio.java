package com.proyecto.social.proyectosocial.servicio;

import com.proyecto.social.proyectosocial.modelo.Organizacion;
import com.proyecto.social.proyectosocial.repository.OrganizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizacionServicio {

    @Autowired
    private OrganizacionRepository organizacionRepository;

    public List<Organizacion> obtenerTodas() {
        return organizacionRepository.findAll();
    }

    public Optional<Organizacion> obtenerPorId(int id) {
        return organizacionRepository.findById(id);
    }

    public Organizacion guardar(Organizacion organizacion) {
        return organizacionRepository.save(organizacion);
    }

    public void eliminar(int id) {
        organizacionRepository.deleteById(id);
    }


}
