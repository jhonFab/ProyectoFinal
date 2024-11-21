package com.proyecto.social.proyectosocial.servicio;

import com.proyecto.social.proyectosocial.modelo.Usuario;
import com.proyecto.social.proyectosocial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> obtenerPorId(int id) {
        return usuarioRepository.findById(id);
    }

    // Guardar o actualizar un usuario
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario por ID
    public void eliminar(int id) {
        usuarioRepository.deleteById(id);
    }
}
