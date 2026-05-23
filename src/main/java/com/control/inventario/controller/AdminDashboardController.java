package com.control.inventario.controller;

import com.control.inventario.repository.EquipoRepository;
import com.control.inventario.repository.ReservaRepository;
import com.control.inventario.repository.UsuarioRepository;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminDashboardController {

    private final EquipoRepository equipoRepository;

    private final UsuarioRepository usuarioRepository;

    private final ReservaRepository reservaRepository;

    // CONSTRUCTOR
    public AdminDashboardController(

            EquipoRepository equipoRepository,

            UsuarioRepository usuarioRepository,

            ReservaRepository reservaRepository
    ) {

        this.equipoRepository = equipoRepository;

        this.usuarioRepository = usuarioRepository;

        this.reservaRepository = reservaRepository;
    }

    // DASHBOARD PRINCIPAL
    @GetMapping("/admin/dashboard")
    public String dashboard(
            Model model
    ) {

        model.addAttribute(
                "totalEquipos",
                equipoRepository.count()
        );

        model.addAttribute(
                "equiposDisponibles",
                equipoRepository.countByEstado(
                        "DISPONIBLE"
                )
        );

        model.addAttribute(
                "totalReservas",
                reservaRepository.count()
        );

        model.addAttribute(
                "totalUsuarios",
                usuarioRepository.count()
        );

        return "admin-dashboard";
    }

    // INICIO DINAMICO
    @GetMapping("/admin/inicio")
    public String inicio(
            Model model
    ) {

        model.addAttribute(
                "totalEquipos",
                equipoRepository.count()
        );

        model.addAttribute(
                "equiposDisponibles",
                equipoRepository.countByEstado(
                        "DISPONIBLE"
                )
        );

        model.addAttribute(
                "totalReservas",
                reservaRepository.count()
        );

        model.addAttribute(
                "totalUsuarios",
                usuarioRepository.count()
        );

        return "fragments/admin-inicio";
    }
}