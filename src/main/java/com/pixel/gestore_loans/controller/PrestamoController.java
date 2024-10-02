package com.pixel.gestore_loans.controller;

import com.pixel.gestore_loans.entity.Prestamo;
import com.pixel.gestore_loans.service.impl.PrestamoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/getPrestamo")
public class PrestamoController {
    @Autowired
    PrestamoServiceImpl prestamoService;

    @GetMapping("/all")
    public List<Prestamo> readAll(){
        return prestamoService.readAll();
    }
}
