package com.Backend.SpendTrack.RecordatoriosCrud.Services;

import com.Backend.SpendTrack.Cliente.Models.Cliente;
import com.Backend.SpendTrack.Cliente.Repositories.ClienteRepository;
import com.Backend.SpendTrack.GastosCrud.Models.Gastos;
import com.Backend.SpendTrack.RecordatoriosCrud.Models.Recordatorio;
import com.Backend.SpendTrack.RecordatoriosCrud.Repositories.IRecordatorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecorService {

    @Autowired
    private IRecordatorios iRecordatorios;

    @Autowired
    private ClienteRepository clienteRepo;

    public ArrayList<Recordatorio> GetAllRecordatorios(){

        try {
            return (ArrayList<Recordatorio>) iRecordatorios.findAll();
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al obtener todos los gastos", e);
        }
    }

    private Boolean buscar(Long id){
        return iRecordatorios.findById(id).isPresent();
    }

    public Recordatorio getRecordatorio(Long id){
        if(!buscar(id)){return null;}
        try{
            return iRecordatorios.findById(id).get();
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al obtener todos los gastos", e);
        }
    }

    public Boolean createRecordatorio(Long clienteId, Recordatorio recor){
        if(recor == null){return false;}
        try{
            Cliente cliente = clienteRepo.findById(clienteId).orElse(null);
            if (cliente != null) {
                recor.setCliente(cliente);
                iRecordatorios.save(recor);
                return true;
            }
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al obtener todos los gastos", e);
        }
        return false;
    }


    public Recordatorio updateRecordatorio(Recordatorio request, Long id){
        if(!buscar(id)){return null;}
        if(request == null){return null;}
        try{
            request.setId(id);
            return iRecordatorios.save(request);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al obtener todos los gastos", e);
        }
    }

    public Boolean deleteRecordatorio(Long id){
        if(!buscar(id)){return false;}
        try{
            iRecordatorios.deleteById(id);
            return true;
        }catch (Exception e){
            throw new RuntimeException("Ocurrio en error al obtener todos los gastos", e);
        }
    }

    public List<Recordatorio> getRecordatoriosByClienteId(Long clienteId) {
        try {
            return iRecordatorios.findByClienteId(clienteId);
        }catch (Exception e){
            throw new RuntimeException("Ocurrio un error al obtener gastos del cliente",e);
        }
    }
}
