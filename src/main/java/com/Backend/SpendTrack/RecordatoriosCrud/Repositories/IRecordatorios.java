package com.Backend.SpendTrack.RecordatoriosCrud.Repositories;


import com.Backend.SpendTrack.RecordatoriosCrud.Models.Recordatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecordatorios extends JpaRepository<Recordatorio, Long> {
    List<Recordatorio> findByClienteId(Long clienteId);
}
