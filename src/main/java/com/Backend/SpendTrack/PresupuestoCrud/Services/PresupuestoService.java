package com.Backend.SpendTrack.PresupuestoCrud.Services;

import com.Backend.SpendTrack.ClienteCrud.Models.Cliente;
import com.Backend.SpendTrack.ClienteCrud.Repositories.ClienteRepository;
import com.Backend.SpendTrack.PresupuestoCrud.Models.Presupuesto;
import com.Backend.SpendTrack.PresupuestoCrud.Repositories.PresupuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresupuestoService {

    @Autowired
    private PresupuestoRepository presupuestoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    private boolean buscar(Long id){
        return presupuestoRepository.findById(id).isPresent();
    }

    public boolean validarPresupuesto(Presupuesto presupuesto) {
        if (presupuesto == null) {return false;}
        if (presupuesto.getFecha() == null) {return false;}
        if (presupuesto.getCategoria() == null || presupuesto.getCategoria().isEmpty()) {return false;}
        if (presupuesto.getCantidad() <= 0) {return false;}
        if (presupuesto.getDescripcion()== null || presupuesto.getDescripcion().isEmpty()) {return false;}

        return true;
    }

    public List<Presupuesto> getAllPresupuestos() {
        try {
            return presupuestoRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al obtener todos los presupuestos", e);
        }
    }

    public Presupuesto getPresupuestoById(Long id) {
        if (!buscar(id)){return null;}
        try {
            return presupuestoRepository.findById(id).orElse(null);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al obtener un presupuesto", e);
        }
    }

    public Presupuesto createPresupuesto(Long clienteId, Presupuesto presupuesto) {
        if(!validarPresupuesto(presupuesto)){return null;}
        try {
            Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
            if (cliente != null) {
                presupuesto.setCliente(cliente);
                return presupuestoRepository.save(presupuesto);
            }
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al crear el presupuesto", e);
        }
        return null;
    }

    public Presupuesto updatePresupuesto(Long id, Presupuesto presupuesto) {
        if(!validarPresupuesto(presupuesto)){return null;}
        if (!buscar(id)){return null;}
        try {
            presupuesto.setId(id);
            return presupuestoRepository.save(presupuesto);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al actualizar el presupuesto", e);
        }
    }

    public void deletePresupuesto(Long id) {
        if (!buscar(id)){return;}
        try {
            presupuestoRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al eliminar el presupuesto", e);
        }
    }

    public List<Presupuesto> getPresupuestosByClienteId(Long clienteId) {
        try {
            return presupuestoRepository.findByClienteId(clienteId);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al obtener los presupuestos del cliente", e);
        }
    }

}
