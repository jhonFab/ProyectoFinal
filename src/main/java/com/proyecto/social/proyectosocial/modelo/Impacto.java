package com.proyecto.social.proyectosocial.modelo;

import jakarta.persistence.*;
//import javax.persistence.*;

@Entity
public class Impacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental
    private int impacto_id;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false) // Llave foránea
    private Proyecto proyecto;

    private int beneficiarios;

    private double satisfaccion; // Porcentaje de satisfacción (ejemplo: 85.5)

    private String otros_indicadores; // Texto descriptivo para costos, mejoras, etc.

    // Constructor vacío (necesario para JPA)
    public Impacto() {}

    // Constructor con parámetros
    public Impacto(Proyecto proyecto, int beneficiarios, double satisfaccion, String otros_indicadores) {
        this.proyecto = proyecto;
        this.beneficiarios = beneficiarios;
        this.satisfaccion = satisfaccion;
        this.otros_indicadores = otros_indicadores;
    }

    // Getters y Setters
    public int getImpacto_id() {
        return impacto_id;
    }

    public void setImpacto_id(int impacto_id) {
        this.impacto_id = impacto_id;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public int getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(int beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public double getSatisfaccion() {
        return satisfaccion;
    }

    public void setSatisfaccion(double satisfaccion) {
        this.satisfaccion = satisfaccion;
    }

    public String getOtros_indicadores() {
        return otros_indicadores;
    }

    public void setOtros_indicadores(String otros_indicadores) {
        this.otros_indicadores = otros_indicadores;
    }
}

