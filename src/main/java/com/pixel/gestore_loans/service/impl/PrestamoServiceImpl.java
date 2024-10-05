package com.pixel.gestore_loans.service.impl;

import com.pixel.gestore_loans.entity.Prestamo;
import com.pixel.gestore_loans.exception.ResourceNotFoundException;
import com.pixel.gestore_loans.repository.ClienteRepository;
import com.pixel.gestore_loans.repository.PrestamoRepository;
import com.pixel.gestore_loans.service.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PrestamoServiceImpl implements IPrestamoService {
    @Autowired
    PrestamoRepository prestamoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Prestamo> readAll() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo findById(Long id_Prestamo) {
        return prestamoRepository.findById(id_Prestamo)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + id_Prestamo));
    }

    @Override
    public Prestamo create(Prestamo prestamo){
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo update(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public String delete(Long id_Prestamo) {
        Prestamo prestamo = prestamoRepository.findById(id_Prestamo)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        prestamoRepository.delete(prestamo);
        return "Removed Correctly";
    }

    @Override
    public Prestamo updatePartial(Long id_Prestamo, Map<String, Object> updates) {
        Prestamo prestamo = findById(id_Prestamo);
        updates.forEach((key, value) -> {
            if (key.equals("estado_Prestamo")) {
                prestamo.setEstatus((String) value);
            } else {
                throw new RuntimeException("Mistake this field does not exist: " + key);
            }
        });
        return prestamoRepository.save(prestamo);
    }

    @Override
    public List<Prestamo> findByEstatus(String estatus){
        return prestamoRepository.findByEstatus(estatus);
    }

}
