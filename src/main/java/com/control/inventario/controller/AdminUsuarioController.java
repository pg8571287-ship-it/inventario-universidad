package com.control.inventario.controller;

import com.control.inventario.model.Usuario;

import com.control.inventario.service.UsuarioService;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminUsuarioController {

    private final UsuarioService usuarioService;

    // CONSTRUCTOR
    public AdminUsuarioController(
            UsuarioService usuarioService
    ) {

        this.usuarioService = usuarioService;
    }

    // LISTAR USUARIOS
    @GetMapping("/admin/usuarios")
    public String usuarios(
            Model model
    ) {

        model.addAttribute(
                "usuarios",
                usuarioService.listarUsuarios()
        );

        return "fragments/admin-usuarios";
    }

    // FORMULARIO EDITAR
    @GetMapping("/admin/usuarios/editar/{id}")
    public String editarUsuario(
            @PathVariable Long id,
            Model model
    ) {

        Usuario usuario =
                usuarioService.buscarPorId(id);

        model.addAttribute(
                "usuario",
                usuario
        );

        return "editar-usuario";
    }

    // ACTUALIZAR
    @PostMapping("/admin/usuarios/actualizar")
    public String actualizarUsuario(
            Usuario usuario
    ) {

        usuarioService.actualizarUsuario(usuario);

        return "redirect:/admin/dashboard";
    }

    // ELIMINAR
    @GetMapping("/admin/usuarios/eliminar/{id}")
    public String eliminarUsuario(
            @PathVariable Long id
    ) {

        usuarioService.eliminarUsuario(id);

        return "redirect:/admin/dashboard";
    }
}