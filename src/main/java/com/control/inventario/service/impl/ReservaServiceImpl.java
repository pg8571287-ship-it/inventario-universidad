package com.control.inventario.service.impl;

import com.control.inventario.model.Reserva;

import com.control.inventario.repository.ReservaRepository;

import com.control.inventario.service.ReservaService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl
        implements ReservaService {

    private final ReservaRepository reservaRepository;

    // CONSTRUCTOR
    public ReservaServiceImpl(
            ReservaRepository reservaRepository
    ) {

        this.reservaRepository = reservaRepository;
    }

    // LISTAR
    @Override
    public List<Reserva> listarReservas() {

        return reservaRepository.findAll();
    }

    // BUSCAR
    @Override
    public Reserva buscarPorId(
            Long id
    ) {

        return reservaRepository
                .findById(id)
                .orElse(null);
    }

    // GUARDAR
  @Override
public Reserva guardarReserva(
        Reserva reserva
) {

    return reservaRepository.save(reserva);
}

@Override
public boolean equipoDisponible(
        Reserva reserva
) {

    return true;
}


}