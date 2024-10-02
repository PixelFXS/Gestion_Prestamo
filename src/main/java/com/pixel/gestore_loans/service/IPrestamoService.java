package com.pixel.gestore_loans.service;

import com.pixel.gestore_loans.entity.Prestamo;

import java.util.List;

public interface IPrestamoService {
    List<Prestamo> readAll();
}
