package com.pixel.gestore_loans.repository;

import com.pixel.gestore_loans.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
