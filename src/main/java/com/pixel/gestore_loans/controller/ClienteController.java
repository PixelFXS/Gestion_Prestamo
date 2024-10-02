package com.pixel.gestore_loans.controller;

import com.pixel.gestore_loans.entity.Cliente;
import com.pixel.gestore_loans.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/getCliente")
public class ClienteController {
    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/all")
    public List<Cliente> readAll(){
        return clienteService.readAll();
    }

}
