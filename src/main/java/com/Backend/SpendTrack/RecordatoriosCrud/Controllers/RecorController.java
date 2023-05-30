package com.Backend.SpendTrack.RecordatoriosCrud.Controllers;

import com.Backend.SpendTrack.GastosCrud.Models.Gastos;
import com.Backend.SpendTrack.RecordatoriosCrud.Models.Recordatorio;
import com.Backend.SpendTrack.RecordatoriosCrud.Services.RecorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/recordatorios")
@CrossOrigin
public class RecorController {

    @Autowired
    private RecorService recorService;

    @GetMapping
    public ArrayList<Recordatorio> GetAllRecordatorios(){
        return recorService.GetAllRecordatorios();
    }

    @GetMapping(path = "/{id}")
    public Recordatorio getRecordatorio(@PathVariable("id")Long id){
        return recorService.getRecordatorio(id);
    }

    @PostMapping(path = "/{clienteId}")
    public boolean createRecordatorio(@PathVariable Long clienteId, @RequestBody Recordatorio recor){
        return recorService.createRecordatorio(clienteId, recor);
    }

    @PutMapping(path = "/{id}")
    public Recordatorio updateRecordatorio(@RequestBody Recordatorio request, @PathVariable("id") Long id){
        return recorService.updateRecordatorio(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteRecordatorio(@PathVariable("id") Long id){
        return recorService.deleteRecordatorio(id);
    }

    @GetMapping("/clientes/{clienteId}")
    public List<Recordatorio> getRecordatorioByClienteId(@PathVariable Long clienteId) {
        return recorService.getRecordatoriosByClienteId(clienteId);
    }
}
