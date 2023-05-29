package com.Backend.SpendTrack.Presupuesto.Controllers;

import com.Backend.SpendTrack.Presupuesto.Models.Presupuesto;
import com.Backend.SpendTrack.Presupuesto.Services.PresupuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/presupuestos")
@CrossOrigin
public class PresupuestoController {
    private final PresupuestoService presupuestoService;

    @Autowired
    public PresupuestoController(PresupuestoService presupuestoService) {
        this.presupuestoService = presupuestoService;
    }

    @GetMapping
    public List<Presupuesto> getAllPresupuestos() {
        return presupuestoService.getAllPresupuestos();
    }

    @GetMapping("/{id}")
    public Presupuesto getPresupuestoById(@PathVariable Long id) {
        return presupuestoService.getPresupuestoById(id);
    }

    @PostMapping("/{clienteId}")
    public Presupuesto createPresupuesto(@PathVariable Long clienteId, @RequestBody Presupuesto presupuesto) {
        return presupuestoService.createPresupuesto(clienteId, presupuesto);
    }

    @PutMapping("/{id}")
    public Presupuesto updatePresupuesto(@PathVariable Long id, @RequestBody Presupuesto presupuesto) {
        return presupuestoService.updatePresupuesto(id, presupuesto);
    }

    @DeleteMapping("/{id}")
    public void deletePresupuesto(@PathVariable Long id) {
        presupuestoService.deletePresupuesto(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Presupuesto> getPresupuestosByClienteId(@PathVariable Long clienteId) {
        return presupuestoService.getPresupuestosByClienteId(clienteId);
    }

}
