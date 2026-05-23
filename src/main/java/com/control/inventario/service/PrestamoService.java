package com.control.inventario.service;

import com.control.inventario.model.Prestamo;

import java.util.List;

public interface PrestamoService {

    List<Prestamo> listarPrestamos();

    Prestamo guardarPrestamo(Prestamo prestamo);
}
