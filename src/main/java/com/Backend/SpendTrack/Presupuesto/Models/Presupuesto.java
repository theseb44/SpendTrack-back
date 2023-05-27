package com.Backend.SpendTrack.Presupuesto.Models;

import com.Backend.SpendTrack.Cliente.Models.Cliente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Presupuestos")
public class Presupuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "descripcion")
    private String descripcion;

}
