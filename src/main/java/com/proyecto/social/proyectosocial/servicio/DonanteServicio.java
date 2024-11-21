package com.proyecto.social.proyectosocial.servicio;

import com.proyecto.social.proyectosocial.modelo.Donante;
import com.proyecto.social.proyectosocial.repository.DonanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonanteServicio {

    @Autowired
    private DonanteRepository donanteRepository;
    //comentario de prueba


    // Obtener todos los donantes
    public List<Donante> obtenerTodos() {
        return donanteRepository.findAll();
    }


    // Obtener un donante por ID
    public Optional<Donante> obtenerPorId(int id) {
        return donanteRepository.findById(id);
    }

    // Guardar o actualizar un donante
    public Donante guardar(Donante donante) {
        return donanteRepository.save(donante);
    }

    // Eliminar un donante
    public void eliminar(int id) {
        donanteRepository.deleteById(id);
    }
}
