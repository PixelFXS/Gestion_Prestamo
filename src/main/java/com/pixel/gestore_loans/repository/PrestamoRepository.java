package com.pixel.gestore_loans.repository;

import com.pixel.gestore_loans.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    Optional<Prestamo> findById(Long id_Prestamo);

    List<Prestamo> findByEstatus(String estatus);
}
