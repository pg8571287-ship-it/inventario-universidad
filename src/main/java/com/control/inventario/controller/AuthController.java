package com.control.inventario.controller;

import com.control.inventario.model.Usuario;

import com.control.inventario.service.UsuarioService;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UsuarioService usuarioService;

    // CONSTRUCTOR
    public AuthController(
            UsuarioService usuarioService
    ) {

        this.usuarioService = usuarioService;
    }

    // LOGIN
    @GetMapping("/login")
    public String login() {

        return "login";
    }

    // REGISTRO
    @GetMapping("/registro")
    public String registro(
            Model model
    ) {

        model.addAttribute(
                "usuario",
                new Usuario()
        );

        return "registro";
    }

    // GUARDAR USUARIO
    @PostMapping("/guardar-usuario")
    public String guardarUsuario(

            @ModelAttribute Usuario usuario,

            Model model
    ) {

        try {

            usuarioService
                    .guardarUsuario(usuario);

            return "redirect:/login";

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    e.getMessage()
            );

            model.addAttribute(
                    "usuario",
                    usuario
            );

            return "registro";
        }
    }
}