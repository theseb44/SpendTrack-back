package com.Backend.SpendTrack.Presupuesto.Services;

import com.Backend.SpendTrack.Cliente.Models.Cliente;
import com.Backend.SpendTrack.Cliente.Repositories.ClienteRepository;
import com.Backend.SpendTrack.Presupuesto.Models.Presupuesto;
import com.Backend.SpendTrack.Presupuesto.Repositories.PresupuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresupuestoService {

    @Autowired
    private PresupuestoRepository presupuestoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Presupuesto> getAllPresupuestos() {
        return presupuestoRepository.findAll();
    }

    public Presupuesto getPresupuestoById(Long id) {
        return presupuestoRepository.findById(id).orElse(null);
    }

    public Presupuesto createPresupuesto(Long clienteId, Presupuesto presupuesto) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (cliente != null) {
            presupuesto.setCliente(cliente);
            return presupuestoRepository.save(presupuesto);
        }
        return null;
    }

    public Presupuesto updatePresupuesto(Long id, Presupuesto presupuesto) {
        presupuesto.setId(id);
        return presupuestoRepository.save(presupuesto);
    }

    public void deletePresupuesto(Long id) {
        presupuestoRepository.deleteById(id);
    }

    public List<Presupuesto> getPresupuestosByClienteId(Long clienteId) {
        return presupuestoRepository.findByClienteId(clienteId);
    }

}
