package com.proyecto.social.proyectosocial.controller;

import com.proyecto.social.proyectosocial.modelo.Mensaje;
import com.proyecto.social.proyectosocial.servicio.MensajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    @Autowired
    private MensajeServicio mensajeServicio;

    // Obtener todos los mensajes
    @GetMapping
    public List<Mensaje> listarTodos() {
        return mensajeServicio.obtenerTodos();
    }

    // Obtener un mensaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> obtenerPorId(@PathVariable int id) {
        Optional<Mensaje> mensaje = mensajeServicio.obtenerPorId(id);
        return mensaje.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo mensaje
    @PostMapping
    public Mensaje crear(@RequestBody Mensaje mensaje) {
        mensaje.setFecha_envio(new Date()); // Establecer la fecha actual al enviar
        return mensajeServicio.guardar(mensaje);
    }

    // Actualizar un mensaje existente
    @PutMapping("/{id}")
    public ResponseEntity<Mensaje> actualizar(@PathVariable int id, @RequestBody Mensaje mensaje) {
        Optional<Mensaje> mensajeExistente = mensajeServicio.obtenerPorId(id);
        if (mensajeExistente.isPresent()) {
            Mensaje mensajeActualizado = mensajeExistente.get();
            mensajeActualizado.setContenido(mensaje.getContenido());
            mensajeActualizado.setFecha_envio(new Date()); // Actualizamos la fecha al actualizar
            mensajeServicio.guardar(mensajeActualizado);
            return ResponseEntity.ok(mensajeActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un mensaje por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        if (mensajeServicio.obtenerPorId(id).isPresent()) {
            mensajeServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


