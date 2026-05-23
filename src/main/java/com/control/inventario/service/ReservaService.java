package com.control.inventario.service;

import com.control.inventario.model.Reserva;

import java.util.List;

public interface ReservaService {

    // LISTAR
    List<Reserva> listarReservas();

    // GUARDAR
    Reserva guardarReserva(
            Reserva reserva
    );

    // BUSCAR
    Reserva buscarPorId(
            Long id
    );

    // VALIDAR DISPONIBILIDAD
    boolean equipoDisponible(
            Reserva reserva
    );
}