package com.control.inventario.controller;

import com.control.inventario.model.Reserva;
import com.control.inventario.model.Usuario;

import com.control.inventario.service.EquipoService;
import com.control.inventario.service.ReservaService;
import com.control.inventario.service.UsuarioService;

import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final EquipoService equipoService;

    private final UsuarioService usuarioService;

    private final ReservaService reservaService;

    // CONSTRUCTOR
    public DashboardController(

            EquipoService equipoService,

            UsuarioService usuarioService,

            ReservaService reservaService
    ) {

        this.equipoService = equipoService;

        this.usuarioService = usuarioService;

        this.reservaService = reservaService;
    }

    @GetMapping("/dashboard")
    public String dashboard(

            Model model,

            Authentication authentication
    ) {

        // USUARIO LOGUEADO
        String correo =
                authentication.getName();

        Usuario usuario =
                usuarioService.buscarPorCorreo(
                        correo
                );

        // ENVIAR USUARIO
        model.addAttribute(
                "usuario",
                usuario
        );

        // RESERVA
        model.addAttribute(
                "reserva",
                new Reserva()
        );

        // CATEGORIAS
        model.addAttribute(
                "categorias",
                equipoService.listarCategorias()
        );

        // MIS RESERVAS
        model.addAttribute(
                "misReservas",
                reservaService.listarReservas()
        );

        return "dashboard";
    }
}