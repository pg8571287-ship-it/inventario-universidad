package com.control.inventario.service.impl;

import com.control.inventario.model.Equipo;

import com.control.inventario.repository.EquipoRepository;

import com.control.inventario.service.EquipoService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServiceImpl
        implements EquipoService {

    private final EquipoRepository equipoRepository;

    // CONSTRUCTOR
    public EquipoServiceImpl(
            EquipoRepository equipoRepository
    ) {

        this.equipoRepository = equipoRepository;
    }

    // LISTAR EQUIPOS
    @Override
    public List<Equipo> listarEquipos() {

        return equipoRepository.findAll();
    }

    // GUARDAR EQUIPO
    @Override
    public Equipo guardarEquipo(
            Equipo equipo
    ) {

        return equipoRepository.save(
                equipo
        );
    }

    // LISTAR CATEGORIAS
    @Override
    public List<String> listarCategorias() {

        return equipoRepository.listarCategorias();
    }

    // BUSCAR DISPONIBLE
    @Override
    public Equipo buscarPrimerDisponiblePorCategoria(
            String categoria
    ) {

        return equipoRepository
                .findByCategoria(categoria)
                .stream()
                .filter(e -> e.getEstado()
                        .equals("DISPONIBLE"))
                .findFirst()
                .orElse(null);
    }
}