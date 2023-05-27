package com.Backend.SpendTrack.RecordatoriosCrud.Controllers;

import com.Backend.SpendTrack.RecordatoriosCrud.Models.Recordatorio;
import com.Backend.SpendTrack.RecordatoriosCrud.Services.RecorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/recordatorios")
public class RecorController {

    @Autowired
    private RecorService recorService;

    @GetMapping
    public ArrayList<Recordatorio> GetAll(){
        return recorService.GetAllRecordatorios();
    }

    @GetMapping(path = "/{id}")
    public Recordatorio get(@PathVariable("id")Long id){
        return recorService.getRecordatorio(id);
    }

    @PostMapping
    public boolean post(@RequestBody Recordatorio recor){
        return recorService.createRecordatorio(recor);
    }

    @PutMapping(path = "/{id}")
    public Recordatorio update(@RequestBody Recordatorio request, @PathVariable("id") Long id){
        return recorService.updateRecordatorio(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return recorService.deleteRecordatorio(id);
    }
}
