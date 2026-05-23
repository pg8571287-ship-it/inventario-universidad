package com.control.inventario.repository;

import com.control.inventario.model.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository
        extends JpaRepository<Reserva, Long> {

    // LISTAR POR ESTADO
    List<Reserva> findByEstado(
            String estado
    );
}