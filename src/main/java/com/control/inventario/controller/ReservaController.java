package com.control.inventario.controller;

import com.control.inventario.model.Reserva;

import com.control.inventario.service.ReservaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(
            ReservaService reservaService) {

        this.reservaService = reservaService;
    }

    // LISTAR
    @GetMapping
    public List<Reserva> listarReservas() {

        return reservaService.listarReservas();
    }

    // GUARDAR
    @PostMapping
    public Reserva guardarReserva(
            @RequestBody Reserva reserva) {

        return reservaService.guardarReserva(reserva);
    }
}
