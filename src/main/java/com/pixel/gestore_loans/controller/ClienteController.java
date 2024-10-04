package com.pixel.gestore_loans.controller;

import com.pixel.gestore_loans.entity.Cliente;
import com.pixel.gestore_loans.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/getCliente")
public class ClienteController {
    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/all")
    public List<Cliente> readAll(){
        return clienteService.readAll();
    }

    @PostMapping("/create")
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.create(cliente);
    }

    @PutMapping("/clienteUpdate")
    public Cliente update(@RequestBody Cliente cliente){
        return clienteService.update(cliente);
    }

    @PatchMapping(value = "/anUpdate/{id_Cliente}")
    public Cliente updatePartial(@PathVariable Long id_Cliente, @RequestBody Map<String, Object> updates) {
        return clienteService.updatePartial(id_Cliente, updates);
    }

    @DeleteMapping("/delete/{id_Cliente}")
    public String delete(@PathVariable("id_Cliente") Long id_Cliente) {
        return clienteService.delete(id_Cliente);
    }
}
