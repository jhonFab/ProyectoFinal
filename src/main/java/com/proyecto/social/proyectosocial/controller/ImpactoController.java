package com.proyecto.social.proyectosocial.controller;

import com.proyecto.social.proyectosocial.modelo.Impacto;
import com.proyecto.social.proyectosocial.modelo.Proyecto;
import com.proyecto.social.proyectosocial.servicio.ImpactoServicio;
import com.proyecto.social.proyectosocial.servicio.ProyectoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/impactos")
public class ImpactoController {

    @Autowired
    private ImpactoServicio impactoServicio;

    @Autowired
    private ProyectoServicio proyectoServicio;

    // Obtener todos los registros de impacto
    @GetMapping
    public List<Impacto> listarTodos() {
        return impactoServicio.obtenerTodos();
    }

    // Obtener un registro de impacto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Impacto> obtenerPorId(@PathVariable int id) {
        Optional<Impacto> impacto = impactoServicio.obtenerPorId(id);
        return impacto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo registro de impacto
    @PostMapping
    public ResponseEntity<Impacto> crear(@RequestBody Impacto impacto) {
        Optional<Proyecto> proyecto = proyectoServicio.obtenerPorId(impacto.getProyecto().getProyecto_id());
        if (proyecto.isPresent()) {
            impacto.setProyecto(proyecto.get());
            Impacto nuevoImpacto = impactoServicio.guardar(impacto);
            return ResponseEntity.ok(nuevoImpacto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Actualizar un registro de impacto
    @PutMapping("/{id}")
    public ResponseEntity<Impacto> actualizar(@PathVariable int id, @RequestBody Impacto impacto) {
        Optional<Impacto> impactoExistente = impactoServicio.obtenerPorId(id);
        if (impactoExistente.isPresent()) {
            Impacto actualizado = impactoExistente.get();
            actualizado.setBeneficiarios(impacto.getBeneficiarios());
            actualizado.setSatisfaccion(impacto.getSatisfaccion());
            actualizado.setOtros_indicadores(impacto.getOtros_indicadores());
            actualizado.setProyecto(impacto.getProyecto());
            impactoServicio.guardar(actualizado);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un registro de impacto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        if (impactoServicio.obtenerPorId(id).isPresent()) {
            impactoServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

