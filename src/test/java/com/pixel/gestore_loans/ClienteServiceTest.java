package com.pixel.gestore_loans;

import com.pixel.gestore_loans.controller.ClienteController;
import com.pixel.gestore_loans.entity.Cliente;
import com.pixel.gestore_loans.repository.ClienteRepository;
import com.pixel.gestore_loans.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    private static final Logger log = LoggerFactory.getLogger(ClienteServiceTest.class);
    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @InjectMocks
    private ClienteController clienteController;
    private List<Cliente> clienteList;
    private Cliente cliente, clienteCreate;

    @BeforeEach
    void setUp() {
        clienteList=new ArrayList<>();
        clienteCreate=new Cliente("1", "Juan Bautista");
        clienteList.add(clienteCreate);

    }

    @Test
    void readAllClient() {
        log.info("Execute read all clients");
        Mockito.when(clienteRepository.findAll()).thenReturn(clienteList);
        List<Cliente> clientResponse=clienteService.readAll();
        assertEquals(clienteList, clientResponse);
        log.info(String.valueOf(clienteList));
    }

    @Test
    void createClient(){
        log.info("Execute create client");
        Mockito.when(clienteRepository.save(clienteCreate)).thenReturn(clienteCreate);
        Cliente createClient=clienteService.create(clienteCreate);
        assertEquals(createClient, clienteCreate);
        log.info(String.valueOf(createClient));
    }

    @Test
    void deleteClient(){
        log.info("Execute delete client");

    }
}

