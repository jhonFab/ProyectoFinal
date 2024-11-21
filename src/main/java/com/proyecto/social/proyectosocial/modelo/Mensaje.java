package com.proyecto.social.proyectosocial.modelo;

//import javax.persistence.*;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental
    private int mensaje_id;

    private String contenido;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_envio;

    // Constructor vacío (necesario para JPA)
    public Mensaje() {}

    // Constructor con parámetros
    public Mensaje(String contenido, Date fecha_envio) {
        this.contenido = contenido;
        this.fecha_envio = fecha_envio;
    }

    // Getters y Setters
    public int getMensaje_id() {
        return mensaje_id;
    }

    public void setMensaje_id(int mensaje_id) {
        this.mensaje_id = mensaje_id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }
}
