package com.control.inventario.repository;

import com.control.inventario.model.Equipo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipoRepository
        extends JpaRepository<Equipo, Long> {

    // LISTAR CATEGORIAS
    @Query("""

    SELECT DISTINCT e.categoria

    FROM Equipo e

    """)
    List<String> listarCategorias();

    // BUSCAR POR CATEGORIA
    List<Equipo> findByCategoria(
            String categoria
    );

    // CONTAR DISPONIBLES
    long countByEstado(
            String estado
    );
}