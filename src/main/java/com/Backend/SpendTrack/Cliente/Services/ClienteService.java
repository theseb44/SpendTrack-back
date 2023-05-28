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

    public boolean buscar(Long id){
        return clienteRepository.findById(id).isPresent();
    }

    public boolean validarCliente(Cliente cliente) {
        if (cliente == null) {return false;}
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {return false;}
        if (cliente.getApellidos() == null || cliente.getNombre().isEmpty()) {return false;}
        if (cliente.getCiudad()== null || cliente.getCiudad().isEmpty()) {return false;}
        if (cliente.getCorreo() == null || cliente.getCiudad().isEmpty()) {return false;}

        return true;
    }

    public List<Cliente> getAllClientes() {
        try {
            return clienteRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al obtener todos los clientes",e);
        }
    }

    public Cliente getClienteById(Long id) {
        if(!buscar(id)){return null;}
        try {
            return clienteRepository.findById(id).orElse(null);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al obtener el cliente",e);
        }
    }

    public Cliente createCliente(Cliente cliente) {
        if (!validarCliente(cliente)){return null;}
        try {
            return clienteRepository.save(cliente);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al crear el cliente",e);
        }
    }

    public Cliente updateCliente(Long id, Cliente cliente) {
        if (!validarCliente(cliente)){return null;}
        if(!buscar(id)){return null;}
        try {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al actualizar un cliente",e);
        }
    }

    public void deleteCliente(Long id) {
        if(!buscar(id)){return;}
        try {
            clienteRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al eliminar un cliente",e);
        }
    }

    public List<Presupuesto> getPresupuestosByClienteId(Long clienteId) {
        try {
            Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
            if (cliente != null) {
                return presupuestoRepository.findByClienteId(clienteId);
            }
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al obtener al presupuestos del cliente",e);
        }
        return null;
    }

    public List<Gastos> getGastoByClienteId(Long clienteId) {
        try {
            Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
            if (cliente != null) {
                return gastoRepo.findByClienteId(clienteId);
            }
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al obtener gastos del cliente",e);
        }
        return null;
    }

    public List<Recordatorio> getRecordatorioByClienteId(Long clienteId) {
        try {
            Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
            if (cliente != null) {
                return recordatoriosRepo.findByClienteId(clienteId);
            }
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al obtener los recordatorios del cliente",e);
        }
        return null;
    }
}
