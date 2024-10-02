package com.pixel.gestore_loans.service.impl;

import com.pixel.gestore_loans.entity.Prestamo;
import com.pixel.gestore_loans.repository.PrestamoRepository;
import com.pixel.gestore_loans.service.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoServiceImpl implements IPrestamoService {
    @Autowired
    PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> readAll() {
        return prestamoRepository.findAll();
    }
}
