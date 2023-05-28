package com.Backend.SpendTrack.Cliente.Services;

import com.Backend.SpendTrack.Cliente.Models.Cliente;
import com.Backend.SpendTrack.Cliente.Repositories.ClienteRepository;
import com.Backend.SpendTrack.GastosCrud.Models.Gastos;
import com.Backend.SpendTrack.GastosCrud.Repositories.IGastos;
import com.Backend.SpendTrack.Presupuesto.Models.Presupuesto;
import com.Backend.SpendTrack.Presupuesto.Repositories.PresupuestoRepository;
import com.Backend.SpendTrack.RecordatoriosCrud.Models.Recordatorio;
import com.Backend.SpendTrack.RecordatoriosCrud.Repositories.IRecordatorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private IGastos gastoRepo;

    @Autowired
    private IRecordatorios recordatoriosRepo;

    @Autowired
    private PresupuestoRepository presupuestoRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Presupuesto> getPresupuestosByClienteId(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (cliente != null) {
            return presupuestoRepository.findByClienteId(clienteId);
        }
        return null;
    }

    public List<Gastos> getGastoByClienteId(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (cliente != null) {
            return gastoRepo.findByClienteId(clienteId);
        }
        return null;
    }

    public List<Recordatorio> getRecordatorioByClienteId(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (cliente != null) {
            return recordatoriosRepo.findByClienteId(clienteId);
        }
        return null;
    }
}
