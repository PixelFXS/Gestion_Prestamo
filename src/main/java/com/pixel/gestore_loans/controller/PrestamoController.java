package com.pixel.gestore_loans.controller;

import com.pixel.gestore_loans.entity.Cliente;
import com.pixel.gestore_loans.entity.Prestamo;
import com.pixel.gestore_loans.exception.ResourceNotFoundException;
import com.pixel.gestore_loans.repository.ClienteRepository;
import com.pixel.gestore_loans.service.impl.PrestamoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/getPrestamo")
public class PrestamoController {
    @Autowired
    PrestamoServiceImpl prestamoService;
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/all")
    public List<Prestamo> readAll(){
        return prestamoService.readAll();
    }

    @PostMapping("/create/{id_Cliente}")
    public Prestamo create(@RequestBody Prestamo prestamo, @PathVariable Long id_Cliente) {
        Cliente cliente = clienteRepository.findById(id_Cliente)
                .orElseThrow(() -> new ResourceNotFoundException("Mistake: client id not found"));
        prestamo.setCliente(cliente);
        return prestamoService.create(prestamo);
    }

    @PutMapping("/prestamoUpdate")
    public Prestamo update(@RequestBody Prestamo prestamo) {
        Prestamo isExist = prestamoService.findById(prestamo.getId_Prestamo());
        if (prestamo.getCliente() == null) {
            prestamo.setCliente(isExist.getCliente());
        }
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

    @GetMapping("/estado")
    public ResponseEntity<List<Prestamo>> getPrestamosByEstatus(@RequestParam String estatus) {
        List<Prestamo> prestamos = prestamoService.findByEstatus(estatus);
        return ResponseEntity.ok(prestamos);
    }

}
