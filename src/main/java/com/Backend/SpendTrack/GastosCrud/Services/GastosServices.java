package com.Backend.SpendTrack.GastosCrud.Services;

import com.Backend.SpendTrack.GastosCrud.Models.Gastos;
import com.Backend.SpendTrack.GastosCrud.Repositories.IGastos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class GastosServices {

    @Autowired
    private IGastos iGastos;

    private boolean buscar(Long id){
        return iGastos.findById(id).isPresent();
    }


    public ArrayList<Gastos> getAllGastos(){
        return (ArrayList<Gastos>) iGastos.findAll();
    }

    public Gastos getGasto(Long id){

        if(!buscar(id)){
            return null;
        }
        try {//necesarios para manejar errores de base de datos
            return iGastos.findById(id).get();
        }catch (Exception e){
            return null;
        }
    }

    public Boolean createGasto(Gastos gasto){
        if (gasto == null) {return false;}
        try {
            LocalDateTime fechaActual = LocalDateTime.now();//obtiene la fecha actual
            gasto.setFecha(fechaActual);
            iGastos.save(gasto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private Gastos update(Gastos request, Gastos gasto){// asigna los valores del request en el objeto en DB

        LocalDateTime fechaActual = LocalDateTime.now();//obtiene la fecha actual
        gasto.setFecha(fechaActual);
        gasto.setCategoria(request.getCategoria());
        gasto.setCantidad(request.getCantidad());
        gasto.setDescripcion(request.getDescripcion());
        gasto.setTipoPago(request.getTipoPago());
        createGasto(gasto);
        return gasto;//gasto actualizado
    }
    public Gastos updateGasto(Gastos request, Long id ){
        if(request == null){return null;}
        if(!buscar(id)){return null;}
        try{
            Gastos gasto = getGasto(id);
            return update(request, gasto);
        }catch (Exception e){
            return null;
        }
    }

    public Boolean deleteGasto(Long id){
        if(!buscar(id)){return false;}
        try{
            iGastos.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
