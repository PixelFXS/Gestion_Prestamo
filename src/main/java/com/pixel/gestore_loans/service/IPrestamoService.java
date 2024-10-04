package com.pixel.gestore_loans.service;

import com.pixel.gestore_loans.entity.Cliente;
import com.pixel.gestore_loans.entity.Prestamo;

import java.util.List;
import java.util.Map;

public interface IPrestamoService {
    List<Prestamo> readAll();
    Prestamo create(Prestamo prestamo);
    Prestamo update(Prestamo prestamo);
    String delete(Long id_Prestamo);

    Prestamo updatePartial(Long id, Map<String, Object> updates);
}
