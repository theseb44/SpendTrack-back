package com.Backend.SpendTrack.GastosCrud.Controllers;

import com.Backend.SpendTrack.GastosCrud.Models.Gastos;
import com.Backend.SpendTrack.GastosCrud.Services.GastosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gasto")
public class GastoController {

    @Autowired
    private GastosServices gastosService;

    @GetMapping
    public List<Gastos> getAllPresupuestos() {
        return gastosService.getAllGasto();
    }

    @GetMapping("/{id}")
    public Gastos getPresupuestoById(@PathVariable Long id) {
        return gastosService.getGastoById(id);
    }

    @PostMapping("/{clienteId}")
    public Gastos createPresupuesto(@PathVariable Long clienteId, @RequestBody Gastos gastos) {
        return gastosService.createGasto(clienteId, gastos);
    }

    @PutMapping("/{id}")
    public Gastos updatePresupuesto(@PathVariable Long id, @RequestBody Gastos gastos) {
        return gastosService.updateGasto(id, gastos);
    }

    @DeleteMapping("/{id}")
    public void deletePresupuesto(@PathVariable Long id) {
        gastosService.deleteGasto(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Gastos> getGastoByClienteId(@PathVariable Long clienteId) {
        return gastosService.getGastoByClienteId(clienteId);
    }

}
