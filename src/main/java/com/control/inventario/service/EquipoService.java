package com.control.inventario.service;

import com.control.inventario.model.Equipo;

import java.util.List;

public interface EquipoService {

    // LISTAR
    List<Equipo> listarEquipos();

    // GUARDAR
    Equipo guardarEquipo(
            Equipo equipo
    );

    // LISTAR CATEGORIAS
    List<String> listarCategorias();

    // BUSCAR DISPONIBLE
    Equipo buscarPrimerDisponiblePorCategoria(
            String categoria
    );
}