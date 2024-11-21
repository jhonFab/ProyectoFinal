package com.proyecto.social.proyectosocial.controller;

import com.proyecto.social.proyectosocial.modelo.Organizacion;
import com.proyecto.social.proyectosocial.modelo.Proyecto;
import com.proyecto.social.proyectosocial.servicio.OrganizacionServicio;
import com.proyecto.social.proyectosocial.servicio.ProyectoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoServicio proyectoServicio;

    @Autowired
    private OrganizacionServicio organizacionServicio;

    // Obtener todos los proyectos
    @GetMapping
    public List<Proyecto> listarTodos() {
        return proyectoServicio.obtenerTodos();
    }

    // Obtener un proyecto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerPorId(@PathVariable int id) {
        Optional<Proyecto> proyecto = proyectoServicio.obtenerPorId(id);
        return proyecto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo proyecto
    @PostMapping
    public ResponseEntity<Proyecto> crear(@RequestBody Proyecto proyecto) {
        Optional<Organizacion> organizacion = organizacionServicio.obtenerPorId(proyecto.getOrganizacion().getOrganizacionId());
        if (organizacion.isPresent()) {
            proyecto.setOrganizacion(organizacion.get());
            Proyecto nuevoProyecto = proyectoServicio.guardar(proyecto);
            return ResponseEntity.ok(nuevoProyecto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Actualizar un proyecto
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizar(@PathVariable int id, @RequestBody Proyecto proyecto) {
        Optional<Proyecto> proyectoExistente = proyectoServicio.obtenerPorId(id);
        if (proyectoExistente.isPresent()) {
            Proyecto actualizado = proyectoExistente.get();
            actualizado.setNombre(proyecto.getNombre());
            actualizado.setDescripcion(proyecto.getDescripcion());
            actualizado.setEstado(proyecto.getEstado());
            actualizado.setFecha_inicio(proyecto.getFecha_inicio());
            actualizado.setFecha_fin(proyecto.getFecha_fin());
            actualizado.setUbicacion(proyecto.getUbicacion());
            actualizado.setOrganizacion(proyecto.getOrganizacion());
            proyectoServicio.guardar(actualizado);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un proyecto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        if (proyectoServicio.obtenerPorId(id).isPresent()) {
            proyectoServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

