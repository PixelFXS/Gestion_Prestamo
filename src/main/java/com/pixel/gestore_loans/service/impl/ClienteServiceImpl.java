package com.pixel.gestore_loans.service.impl;


import com.pixel.gestore_loans.entity.Cliente;
import com.pixel.gestore_loans.entity.Prestamo;
import com.pixel.gestore_loans.exception.ResourceNotFoundException;
import com.pixel.gestore_loans.repository.ClienteRepository;
import com.pixel.gestore_loans.service.IClienteService;
import org.springframework.util.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public List<Cliente> readAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public String delete(Long id_Cliente) {
        Cliente cliente = clienteRepository.findById(id_Cliente)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        clienteRepository.delete(cliente);
        return "Removed Correctly";
    }


    @Override
    public Cliente updatePartial(Long id_Cliente, Map<String, Object> updates) {
        Cliente cliente = clienteRepository.findById(id_Cliente)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Cliente.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, cliente, value);
            } else {
                throw new RuntimeException("Mistake this field does not exist");
            }
        });

        return clienteRepository.save(cliente);
    }
}
