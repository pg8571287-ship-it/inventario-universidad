package com.control.inventario.repository;

import com.control.inventario.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    // BUSCAR POR CORREO
    Optional<Usuario> findByCorreo(
            String correo
    );

    // VALIDAR CORREO
    boolean existsByCorreo(
            String correo
    );

    // VALIDAR IDENTIFICACION
    boolean existsByIdentificacion(
            String identificacion
    );
}