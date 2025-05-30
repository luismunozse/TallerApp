package com.solucionati.taller.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String apellido;
    @Column(nullable = false, length = 20)
    private String telefono;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 200, columnDefinition = "TEXT")
    private String direccion;
    private LocalDate fechaRegistro;
}
