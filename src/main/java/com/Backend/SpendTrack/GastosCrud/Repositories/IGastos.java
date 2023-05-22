package com.Backend.SpendTrack.GastosCrud.Repositories;

import com.Backend.SpendTrack.GastosCrud.Models.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGastos extends JpaRepository<Gastos,Long> {
}
