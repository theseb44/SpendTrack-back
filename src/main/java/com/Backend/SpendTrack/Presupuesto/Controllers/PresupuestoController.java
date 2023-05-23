package com.Backend.SpendTrack.Presupuesto.Controllers;

import com.Backend.SpendTrack.Presupuesto.Model.Presupuesto;
import com.Backend.SpendTrack.Presupuesto.Services.PresupuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/presupuesto")
public class PresupuestoController {
    @Autowired
    private PresupuestoService presupuestoService;
    @GetMapping
    public List<Presupuesto> getAllPresupuestos(){
        return presupuestoService.getAllPresupuestos();
    }

    @GetMapping(path = "/{id}")
    public Optional<Presupuesto> getPresupuesto(@PathVariable("id") Long id){
        return presupuestoService.getPresupuesto(id);
    }

    @PostMapping
    public Presupuesto createPresupuesto(@RequestBody Presupuesto presupuesto){
        return presupuestoService.createPresupuesto(presupuesto);
    }

    @PutMapping(path = "/{id}")
    public Presupuesto updatePresupuesto(@PathVariable("id") Long id,@RequestBody Presupuesto bodyPresupuesto){
        return presupuestoService.updatePresupuestoById(id, bodyPresupuesto);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deletePresupuesto(@PathVariable("id") Long id){
        return presupuestoService.deletePresupuesto(id);
    }

}
