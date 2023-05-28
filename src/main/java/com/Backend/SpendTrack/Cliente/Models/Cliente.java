package com.Backend.SpendTrack.Cliente.Models;

import com.Backend.SpendTrack.GastosCrud.Models.Gastos;
import com.Backend.SpendTrack.Models.Usuario;
import com.Backend.SpendTrack.Presupuesto.Models.Presupuesto;
import com.Backend.SpendTrack.RecordatoriosCrud.Models.Recordatorio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente extends Usuario {

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Presupuesto> presupuestos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Gastos> gastos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Recordatorio> recordatorios;
}
