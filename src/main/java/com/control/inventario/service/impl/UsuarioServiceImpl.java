package com.control.inventario.service.impl;

import com.control.inventario.model.Usuario;

import com.control.inventario.repository.UsuarioRepository;

import com.control.inventario.service.UsuarioService;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl
        implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    // CONSTRUCTOR
    public UsuarioServiceImpl(

            UsuarioRepository usuarioRepository,

            PasswordEncoder passwordEncoder
    ) {

        this.usuarioRepository = usuarioRepository;

        this.passwordEncoder = passwordEncoder;
    }

    // LISTAR USUARIOS
    @Override
    public List<Usuario> listarUsuarios() {

        return usuarioRepository.findAll();
    }

    // GUARDAR USUARIO
    @Override
    public Usuario guardarUsuario(
            Usuario usuario
    ) {

        // VALIDAR CORREO
        if(usuarioRepository.existsByCorreo(
                usuario.getCorreo()
        )){

            throw new RuntimeException(
                    "El correo ya está registrado"
            );
        }

        // VALIDAR IDENTIFICACION
        if(usuarioRepository.existsByIdentificacion(
                usuario.getIdentificacion()
        )){

            throw new RuntimeException(
                    "La identificación ya está registrada"
            );
        }

        // ENCRIPTAR PASSWORD
        usuario.setPassword(

                passwordEncoder.encode(
                        usuario.getPassword()
                )
        );

        // ROL POR DEFECTO
        usuario.setRol(
                "USUARIO"
        );

        return usuarioRepository.save(
                usuario
        );
    }

    // BUSCAR POR CORREO
    @Override
    public Usuario buscarPorCorreo(
            String correo
    ) {

        return usuarioRepository
                .findByCorreo(correo)
                .orElse(null);
    }

    // BUSCAR POR ID
    @Override
    public Usuario buscarPorId(
            Long id
    ) {

        return usuarioRepository
                .findById(id)
                .orElse(null);
    }

    // ELIMINAR USUARIO
    @Override
    public void eliminarUsuario(
            Long id
    ) {

        usuarioRepository.deleteById(id);
    }

    // ACTUALIZAR USUARIO
    @Override
    public Usuario actualizarUsuario(
            Usuario usuario
    ) {

        Usuario usuarioDB =
                usuarioRepository
                        .findById(usuario.getId())
                        .orElse(null);

        if(usuarioDB != null){

            usuarioDB.setNombre(
                    usuario.getNombre()
            );

            usuarioDB.setCorreo(
                    usuario.getCorreo()
            );

            usuarioDB.setIdentificacion(
                    usuario.getIdentificacion()
            );

            usuarioDB.setRol(
                    usuario.getRol()
            );

            return usuarioRepository.save(
                    usuarioDB
            );
        }

        return null;
    }
}