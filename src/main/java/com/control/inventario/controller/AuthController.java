package com.control.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // LOGIN
    @GetMapping("/login")
    public String login() {

        return "login";
    }

    // REGISTRO
    @GetMapping("/registro")
    public String registro() {

        return "registro";
    }
}