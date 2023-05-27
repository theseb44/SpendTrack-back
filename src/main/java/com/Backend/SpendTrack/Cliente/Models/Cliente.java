package com.Backend.SpendTrack.Cliente.Models;

import com.Backend.SpendTrack.Models.Persona;
import com.Backend.SpendTrack.Presupuesto.Models.Presupuesto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente extends Persona{

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Presupuesto> presupuestos;
}
