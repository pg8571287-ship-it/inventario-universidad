package com.control.inventario.controller;

import com.control.inventario.model.Equipo;
import com.control.inventario.model.Reserva;
import com.control.inventario.model.Usuario;

import com.control.inventario.service.EquipoService;
import com.control.inventario.service.ReservaService;
import com.control.inventario.service.UsuarioService;

import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaWebController {

    private final ReservaService reservaService;

    private final EquipoService equipoService;

    private final UsuarioService usuarioService;

    // CONSTRUCTOR
    public ReservaWebController(

            ReservaService reservaService,

            EquipoService equipoService,

            UsuarioService usuarioService
    ) {

        this.reservaService = reservaService;

        this.equipoService = equipoService;

        this.usuarioService = usuarioService;
    }

    // GUARDAR RESERVA
    @PostMapping("/reservar")
    public String guardarReserva(

            @ModelAttribute Reserva reserva,

            Authentication authentication
    ) {

        // OBTENER CORREO LOGIN
        String correo =
                authentication.getName();

        // BUSCAR USUARIO
        Usuario usuario =
                usuarioService.buscarPorCorreo(
                        correo
                );

        // VALIDAR USUARIO
        if(usuario == null){

            return "redirect:/dashboard?errorusuario";
        }

        // BUSCAR EQUIPO DISPONIBLE
        Equipo equipo =
                equipoService
                        .buscarPrimerDisponiblePorCategoria(
                                reserva.getEquipo()
                                        .getCategoria()
                        );

        // VALIDAR EQUIPO
        if(equipo == null){

            return "redirect:/dashboard?nodisponible";
        }

        // ASIGNAR USUARIO
        reserva.setUsuario(
                usuario
        );

        // ASIGNAR EQUIPO
        reserva.setEquipo(
                equipo
        );

        // ESTADO
        reserva.setEstado(
                "PENDIENTE"
        );

        // GUARDAR
        reservaService.guardarReserva(
                reserva
        );

        return "redirect:/dashboard?ok";
    }
}