package com.pixel.gestore_loans.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")

public class Cliente {
    @Id
    @Column(name = "id_Cliente")
    private String id_Cliente;

    @Column(name = "nombre_Cliente")
    private String nombre_Cliente;
}
