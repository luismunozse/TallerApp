package com.solucionati.taller.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "modelos")
@Data
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;
}
