package com.control.inventario.service;

import com.control.inventario.model.Usuario;

import java.util.List;

public interface UsuarioService {

    // LISTAR USUARIOS
    List<Usuario> listarUsuarios();

    // GUARDAR USUARIO
    Usuario guardarUsuario(
            Usuario usuario
    );

    // BUSCAR POR CORREO
    Usuario buscarPorCorreo(
            String correo
    );

    // BUSCAR POR ID
    Usuario buscarPorId(
            Long id
    );

    // ELIMINAR USUARIO
    void eliminarUsuario(
            Long id
    );

    // ACTUALIZAR USUARIO
    Usuario actualizarUsuario(
            Usuario usuario
    );
}