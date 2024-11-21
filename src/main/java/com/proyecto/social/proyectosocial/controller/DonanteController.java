package com.proyecto.social.proyectosocial.controller;

import com.proyecto.social.proyectosocial.modelo.Donante;
import com.proyecto.social.proyectosocial.servicio.DonanteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donantes")
public class DonanteController {

    @Autowired
    private DonanteServicio donanteServicio;

    // Obtener todos los donantes
    @GetMapping
    public List<Donante> listarTodos() {
        return donanteServicio.obtenerTodos();
    }

    // Obtener un donante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Donante> obtenerPorId(@PathVariable int id) {
        Optional<Donante> donante = donanteServicio.obtenerPorId(id);
        return donante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo donante
    @PostMapping
    public Donante crear(@RequestBody Donante donante) {
        return donanteServicio.guardar(donante);
    }

    // Actualizar un donante existente
    @PutMapping("/{id}")
    public ResponseEntity<Donante> actualizar(@PathVariable int id, @RequestBody Donante donante) {
        Optional<Donante> donanteExistente = donanteServicio.obtenerPorId(id);
        if (donanteExistente.isPresent()) {
            Donante donanteActualizado = donanteExistente.get();
            donanteActualizado.setNombre(donante.getNombre());
            donanteActualizado.setCorreo(donante.getCorreo());
            donanteActualizado.setTelefono(donante.getTelefono());
            donanteActualizado.setDireccion(donante.getDireccion());
            donanteActualizado.setArea(donante.getArea());
            donanteServicio.guardar(donanteActualizado);
            return ResponseEntity.ok(donanteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un donante por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        if (donanteServicio.obtenerPorId(id).isPresent()) {
            donanteServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
