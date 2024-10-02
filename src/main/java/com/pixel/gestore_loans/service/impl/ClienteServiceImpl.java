package com.pixel.gestore_loans.service.impl;


import com.pixel.gestore_loans.entity.Cliente;
import com.pixel.gestore_loans.repository.ClienteRepository;
import com.pixel.gestore_loans.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public List<Cliente> readAll() {
        return clienteRepository.findAll();
    }
}
