package com.Backend.SpendTrack.GastosCrud.Services;

import com.Backend.SpendTrack.Cliente.Models.Cliente;
import com.Backend.SpendTrack.Cliente.Repositories.ClienteRepository;
import com.Backend.SpendTrack.GastosCrud.Models.Gastos;
import com.Backend.SpendTrack.GastosCrud.Repositories.IGastos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GastosServices {

    @Autowired
    private IGastos gastoRepo;

    @Autowired
    private ClienteRepository clienteRepo;
    private boolean buscar(Long id){
        return gastoRepo.findById(id).isPresent();
    }


    public List<Gastos> getAllGasto() {
        try {
            return gastoRepo.findAll();
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al obtener todos los gastos", e);
        }
    }

    public Gastos getGastoById(Long id) {
        if(!buscar(id)){return null;}
        try {
            return gastoRepo.findById(id).orElse(null);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al obtener el gasto", e);
        }
    }

    public Gastos createGasto(Long clienteId, Gastos gasto) {
        try {
            Cliente cliente = clienteRepo.findById(clienteId).orElse(null);
            if (cliente != null) {
                gasto.setCliente(cliente);
                return gastoRepo.save(gasto);
            }
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al crear el gasto",e);
        }
        return null;
    }

    public Gastos updateGasto(Long id, Gastos gasto) {
        try {
            gasto.setId(id);
            return gastoRepo.save(gasto);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al actualizar el gasto",e);
        }
    }

    public void deleteGasto(Long id) {
        try {
            gastoRepo.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al eliminar el gasto",e);
        }
    }

    public List<Gastos> getGastoByClienteId(Long clienteId) {
        try {
            return gastoRepo.findByClienteId(clienteId);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al obtener gastos del cliente",e);
        }
    }
}
