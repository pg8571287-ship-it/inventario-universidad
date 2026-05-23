package com.control.inventario.controller;

import com.control.inventario.model.Equipo;

import com.control.inventario.service.EquipoService;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminEquipoController {

    private final EquipoService equipoService;

    // CONSTRUCTOR
    public AdminEquipoController(
            EquipoService equipoService
    ) {

        this.equipoService = equipoService;
    }

    // MOSTRAR MODULO EQUIPOS
    @GetMapping("/admin/equipos")
    public String equipos(
            Model model
    ) {

        model.addAttribute(
                "equipos",
                equipoService.listarEquipos()
        );

        model.addAttribute(
                "equipo",
                new Equipo()
        );

        return "fragments/admin-equipos";
    }

    // GUARDAR EQUIPO
    @PostMapping("/admin/equipos/guardar")
    public String guardarEquipo(
            @ModelAttribute Equipo equipo
    ) {

        equipoService.guardarEquipo(
                equipo
        );

        return "redirect:/admin/dashboard";
    }
}