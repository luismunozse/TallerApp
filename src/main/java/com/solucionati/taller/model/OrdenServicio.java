package com.solucionati.taller.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordenes_servicio")
@Data
public class OrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 20)
    private String numeroOrden;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;
    @Column(nullable = false, length = 20)
    private String imei;
    @Column(columnDefinition = "TEXT")
    private String descripcionProblema;
    @Column(columnDefinition = "TEXT")
    private String diagnostico;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaEstimada;
    private LocalDateTime fechaEntrega;
    private BigDecimal costoReparacion;
    private BigDecimal costoFinal;

    public enum Estado {
        RECIBIDO,
        EN_PROCESO,
        EN_REPARACION,
        TERMINADO,
        ENTREGADO

    }
}
