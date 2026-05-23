package com.control.inventario.controller;

import com.control.inventario.service.EquipoService;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebEquipoController {

    private final EquipoService equipoService;

    public WebEquipoController(
            EquipoService equipoService) {

        this.equipoService = equipoService;
    }

    // MOSTRAR EQUIPOS
    @GetMapping("/equipos")
    public String mostrarEquipos(Model model) {

        model.addAttribute(
                "equipos",
                equipoService.listarEquipos()
        );

        return "equipos";
    }
}
