package com.proyecto.social.proyectosocial.modelo;

import jakarta.persistence.*;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

@Entity
public class Donante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Esto hace que el ID sea auto-incremental.
    private int donante_id;

    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String area;  // Puede ser: educación, salud, etc.

    // Constructores
    public Donante() {

    }

    public Donante(String nombre, String correo, String telefono, String direccion, String area) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.area = area;
    }

    // Getters y Setters
    public int getDonante_id() {
        return donante_id;
    }

    public void setDonante_id(int donante_id) {
        this.donante_id = donante_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
