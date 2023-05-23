package com.Backend.SpendTrack.Presupuesto.Repositories;

import com.Backend.SpendTrack.Presupuesto.Model.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresupuestoRepository extends JpaRepository<Presupuesto, Long> {
}
