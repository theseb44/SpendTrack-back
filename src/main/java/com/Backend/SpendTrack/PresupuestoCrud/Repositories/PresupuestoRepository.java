package com.Backend.SpendTrack.PresupuestoCrud.Repositories;

import com.Backend.SpendTrack.PresupuestoCrud.Models.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresupuestoRepository extends JpaRepository<Presupuesto, Long> {
    List<Presupuesto> findByClienteId(Long clienteId);
}
