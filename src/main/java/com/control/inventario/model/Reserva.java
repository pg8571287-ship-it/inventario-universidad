package com.control.inventario.model;

import jakarta.persistence.*;

import java.time.LocalDate;

import java.time.LocalTime;

@Entity
@Table(name = "reservas")
public class Reserva {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FECHA
    private LocalDate fechaReserva;

    // HORA INICIO
    private LocalTime horaInicio;

    // HORA FIN
    private LocalTime horaFin;

    // UBICACION
    private String ubicacion;

    // OBSERVACION
    private String observacion;

    // ESTADO
    private String estado;

    // USUARIO
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // EQUIPO
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    // CONSTRUCTOR VACIO
    public Reserva() {

        this.estado = "PENDIENTE";
    }

    // GETTERS Y SETTERS

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public LocalDate getFechaReserva() {

        return fechaReserva;
    }

    public void setFechaReserva(
            LocalDate fechaReserva
    ) {

        this.fechaReserva = fechaReserva;
    }

    public LocalTime getHoraInicio() {

        return horaInicio;
    }

    public void setHoraInicio(
            LocalTime horaInicio
    ) {

        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {

        return horaFin;
    }

    public void setHoraFin(
            LocalTime horaFin
    ) {

        this.horaFin = horaFin;
    }

    public String getUbicacion() {

        return ubicacion;
    }

    public void setUbicacion(
            String ubicacion
    ) {

        this.ubicacion = ubicacion;
    }

    public String getObservacion() {

        return observacion;
    }

    public void setObservacion(
            String observacion
    ) {

        this.observacion = observacion;
    }

    public String getEstado() {

        return estado;
    }

    public void setEstado(
            String estado
    ) {

        this.estado = estado;
    }

    public Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(
            Usuario usuario
    ) {

        this.usuario = usuario;
    }

    public Equipo getEquipo() {

        return equipo;
    }

    public void setEquipo(
            Equipo equipo
    ) {

        this.equipo = equipo;
    }
}