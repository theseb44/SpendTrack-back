package com.Backend.SpendTrack.GastosCrud.Services;

import com.Backend.SpendTrack.ClienteCrud.Models.Cliente;
import com.Backend.SpendTrack.ClienteCrud.Repositories.ClienteRepository;
import com.Backend.SpendTrack.GastosCrud.Models.Gastos;
import com.Backend.SpendTrack.GastosCrud.Repositories.IGastos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private boolean validarGastos(Gastos gastos) {
        if(gastos == null){return false;}
        if (gastos.getFecha() == null) {return false;}
        if (gastos.getCategoria() == null || gastos.getCategoria().isEmpty()) {return false;}
        if (gastos.getCantidad() <= 0) {return false;}
        if (gastos.getTipoPago() == null || gastos.getTipoPago().isEmpty()) {return false;}
        if (gastos.getDescripcion() == null || gastos.getDescripcion().isEmpty()) {return false;}

        return true;
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
        if(!validarGastos(gasto)){return null;}
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
        if(!validarGastos(gasto)){return null;}
        if(!buscar(id)){return null;}
        try {
            Gastos gastoActualizado = gastoRepo.findById(id).get();
            gastoActualizado.setCantidad(gasto.getCantidad());
            gastoActualizado.setTipoPago(gasto.getTipoPago());
            gastoActualizado.setDescripcion(gasto.getDescripcion());
            gastoActualizado.setFecha(gasto.getFecha());
            gastoActualizado.setCategoria(gasto.getCategoria());
            return gastoRepo.save(gastoActualizado);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al actualizar el gasto",e);
        }
    }

    public void deleteGasto(Long id) {
        if(!buscar(id)){return;}
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
