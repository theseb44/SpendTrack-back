package com.Backend.SpendTrack.Presupuesto.Services;

import com.Backend.SpendTrack.Presupuesto.Model.Presupuesto;
import com.Backend.SpendTrack.Presupuesto.Repositories.PresupuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PresupuestoService {
    @Autowired
    PresupuestoRepository presupuestoRepository;

    private boolean buscar(Long id){
        return presupuestoRepository.findById(id).isPresent();
    }

    public List<Presupuesto> getAllPresupuestos(){
        return presupuestoRepository.findAll();
    }

    public Optional<Presupuesto> getPresupuesto(Long id){
        return presupuestoRepository.findById(id);
    }

    public Presupuesto createPresupuesto(Presupuesto presupuesto){
        if (presupuesto.getFecha() == null) presupuesto.setFecha(LocalDateTime.now());

        return presupuestoRepository.save(presupuesto);
    }

    public Presupuesto updatePresupuestoById(Long id, Presupuesto updatePresupuesto){
        Presupuesto presupuesto = presupuestoRepository.findById(id).orElse(null);

        if(presupuesto == null) throw new RuntimeException("La entidad no existe");

        presupuesto.setFecha(LocalDateTime.now());
        presupuesto.setCantidad(updatePresupuesto.getCantidad());
        presupuesto.setCategoria(updatePresupuesto.getCategoria());
        presupuesto.setDescripcion(updatePresupuesto.getDescripcion());

        return presupuestoRepository.save(presupuesto);
    }

    public boolean deletePresupuesto(Long id){
        if(!buscar(id)) return false;
        presupuestoRepository.deleteById(id);
        return true;
    }

}
