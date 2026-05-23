package com.control.inventario.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // RELACION CON USUARIO
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // RELACION CON EQUIPO
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    private LocalDate fechaPrestamo;

    private LocalDate fechaDevolucion;

    private String estado;

    // CONSTRUCTOR VACIO
    public Prestamo() {
    }

    // CONSTRUCTOR COMPLETO
    public Prestamo(Long id, Usuario usuario, Equipo equipo,
                     LocalDate fechaPrestamo,
                     LocalDate fechaDevolucion,
                     String estado) {

        this.id = id;
        this.usuario = usuario;
        this.equipo = equipo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}