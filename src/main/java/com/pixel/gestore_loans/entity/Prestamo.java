package com.pixel.gestore_loans.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prestamo")
@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Prestamo")
    private Long id_Prestamo;


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
