package com.Backend.SpendTrack.GastosCrud.Controllers;

import com.Backend.SpendTrack.GastosCrud.Models.Gastos;
import com.Backend.SpendTrack.GastosCrud.Services.GastosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/gasto")
public class GastoController {

    @Autowired
    private GastosServices gastosServices;
    @GetMapping
    public ArrayList<Gastos> getAll(){
        return gastosServices.getAllGastos();
    }

    @GetMapping(path = "/{id}")
    public Gastos get(@PathVariable("id") Long id){
        return gastosServices.getGasto(id);
    }

    @PostMapping
    public boolean post(@RequestBody Gastos gasto){
        return gastosServices.createGasto(gasto);
    }
    @PutMapping(path = "/{id}")
    public Gastos update(@RequestBody Gastos request, @PathVariable("id") Long id){
        return gastosServices.updateGasto(request, id);
    }
    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return gastosServices.deleteGasto(id);
    }

}
