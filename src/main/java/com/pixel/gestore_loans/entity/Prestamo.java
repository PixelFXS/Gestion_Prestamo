package com.pixel.gestore_loans.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prestamo")

public class Prestamo {
    @ManyToOne
    @JoinColumn(name = "id_Cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "monto_Prestamo")
    private String monto_Prestamo;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "estado_Prestamo")
    private String estado_Prestamo;


}
