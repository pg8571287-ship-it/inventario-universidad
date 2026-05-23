package com.control.inventario.controller;

import com.control.inventario.model.Reserva;

import com.control.inventario.service.ReservaService;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminReservaController {

    private final ReservaService reservaService;

    // CONSTRUCTOR
    public AdminReservaController(
            ReservaService reservaService
    ) {

        this.reservaService = reservaService;
    }

    // LISTAR RESERVAS
    @GetMapping("/admin/reservas")
    public String reservas(
            Model model
    ) {

        model.addAttribute(
                "reservas",
                reservaService.listarReservas()
        );

        return "fragments/admin-reservas";
    }

    // APROBAR
    @GetMapping("/admin/reservas/aprobar/{id}")
    public String aprobarReserva(
            @PathVariable Long id
    ) {

        Reserva reserva =
                reservaService.buscarPorId(id);

        reserva.setEstado(
                "APROBADA"
        );

        reservaService.guardarReserva(
                reserva
        );

        return "redirect:/admin/dashboard";
    }

    // RECHAZAR
    @GetMapping("/admin/reservas/rechazar/{id}")
    public String rechazarReserva(
            @PathVariable Long id
    ) {

        Reserva reserva =
                reservaService.buscarPorId(id);

        reserva.setEstado(
                "RECHAZADA"
        );

        reservaService.guardarReserva(
                reserva
        );

        return "redirect:/admin/dashboard";
    }
}