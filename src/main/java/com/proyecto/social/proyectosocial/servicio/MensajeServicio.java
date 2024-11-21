package com.proyecto.social.proyectosocial.servicio;

import com.proyecto.social.proyectosocial.modelo.Mensaje;
import com.proyecto.social.proyectosocial.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeServicio {

    @Autowired
    private MensajeRepository mensajeRepository;

    // Obtener todos los mensajes
    public List<Mensaje> obtenerTodos() {
        return mensajeRepository.findAll();
    }

    // Obtener un mensaje por ID
    public Optional<Mensaje> obtenerPorId(int id) {
        return mensajeRepository.findById(id);
    }

    // Guardar o actualizar un mensaje
    public Mensaje guardar(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    // Eliminar un mensaje por ID
    public void eliminar(int id) {
        mensajeRepository.deleteById(id);
    }
}

