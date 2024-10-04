package com.pixel.gestore_loans.controller;

import com.pixel.gestore_loans.entity.Cliente;
import com.pixel.gestore_loans.entity.Prestamo;
import com.pixel.gestore_loans.service.impl.PrestamoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/getPrestamo")
public class PrestamoController {
    @Autowired
    PrestamoServiceImpl prestamoService;

    @GetMapping("/all")
    public List<Prestamo> readAll(){
        return prestamoService.readAll();
    }

    @PutMapping("/create")
    public Prestamo create(@RequestBody Prestamo prestamo){
        return prestamoService.create(prestamo);
    }

    @PostMapping("/clienteUpdate")
    public Prestamo update(@RequestBody Prestamo prestamo){
        return prestamoService.update(prestamo);
    }

    @PatchMapping("/anUpdate/{id_Prestamo}")
    public Prestamo updatePartial(@PathVariable Long id_Prestamo, @RequestBody Map<String, Object> updates) {
        return prestamoService.updatePartial(id_Prestamo, updates);
    }

    @DeleteMapping("/delete/{id_Prestamo}")
    public String delete(@PathVariable("id_Prestamo") Long id_Prestamo) {
        return prestamoService.delete(id_Prestamo);
    }
}
