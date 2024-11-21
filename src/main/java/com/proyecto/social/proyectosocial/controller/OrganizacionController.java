package com.proyecto.social.proyectosocial.controller;


import com.proyecto.social.proyectosocial.modelo.Organizacion;
import com.proyecto.social.proyectosocial.servicio.OrganizacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizaciones")
public class OrganizacionController {

    @Autowired
    private OrganizacionServicio organizacionServicio;

    @GetMapping
    public List<Organizacion> listarTodas() {
        return organizacionServicio.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizacion> obtenerPorId(@PathVariable int id) {
        return organizacionServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Organizacion crear(@RequestBody Organizacion organizacion) {
        return organizacionServicio.guardar(organizacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizacion> actualizar(@PathVariable int id, @RequestBody Organizacion organizacion) {
        return organizacionServicio.obtenerPorId(id)
                .map(orgExistente -> {
                    orgExistente.setNombre(organizacion.getNombre());
                    orgExistente.setDescripcion(organizacion.getDescripcion());
                    orgExistente.setContacto(organizacion.getContacto());
                    orgExistente.setDireccion(organizacion.getDireccion());
                    return ResponseEntity.ok(organizacionServicio.guardar(orgExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        if (organizacionServicio.obtenerPorId(id).isPresent()) {
            organizacionServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
