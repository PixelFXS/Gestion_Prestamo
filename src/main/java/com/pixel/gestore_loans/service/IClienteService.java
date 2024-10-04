package com.pixel.gestore_loans.service;

import com.pixel.gestore_loans.entity.Cliente;

import java.util.List;
import java.util.Map;

public interface IClienteService {
    //CRUD Methods
    List<Cliente> readAll();
    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    String delete(Long id_Cliente);

    //Parameterized and custom methods
    Cliente updatePartial(Long id, Map<String, Object> updates);
}
