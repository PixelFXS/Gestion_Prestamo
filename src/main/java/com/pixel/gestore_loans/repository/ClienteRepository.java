package com.pixel.gestore_loans.repository;

import com.pixel.gestore_loans.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
}
