package com.Backend.SpendTrack.RecordatoriosCrud.Services;

import com.Backend.SpendTrack.RecordatoriosCrud.Models.Recordatorio;
import com.Backend.SpendTrack.RecordatoriosCrud.Repositories.IRecordatorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecorService {

    @Autowired
    private IRecordatorios iRecordatorios;

    public ArrayList<Recordatorio> GetAllRecordatorios(){
        return (ArrayList<Recordatorio>) iRecordatorios.findAll();
    }

    private Boolean buscar(Long id){
        return iRecordatorios.findById(id).isPresent();
    }

    public Recordatorio getRecordatorio(Long id){
        if(!buscar(id)){return null;}
        try{
            return iRecordatorios.findById(id).get();
        }catch (Exception e){
            return null;
        }
    }

    public Boolean createRecordatorio(Recordatorio recor){
        if(recor == null){return false;}
        try{
            iRecordatorios.save(recor);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private Recordatorio actualizar(Recordatorio request, Long id){
        Recordatorio recor = getRecordatorio(id);
        recor.setDescripcion(request.getDescripcion());
        recor.setTitulo(request.getTitulo());
        createRecordatorio(recor);
        return recor;
    }
    public Recordatorio updateRecordatorio(Recordatorio request, Long id){
        if(!buscar(id)){return null;}
        if(request == null){return null;}
        try{
            return actualizar(request, id);
        }catch (Exception e){
            return null;
        }
    }

    public Boolean deleteRecordatorio(Long id){
        if(!buscar(id)){return false;}
        try{
            iRecordatorios.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
