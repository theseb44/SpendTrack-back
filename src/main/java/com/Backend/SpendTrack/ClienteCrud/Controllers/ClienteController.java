package com.Backend.SpendTrack.ClienteCrud.Controllers;

import com.Backend.SpendTrack.ClienteCrud.Models.Cliente;
import com.Backend.SpendTrack.ClienteCrud.Services.ClienteService;
import com.Backend.SpendTrack.GastosCrud.Models.Gastos;
import com.Backend.SpendTrack.PresupuestoCrud.Models.Presupuesto;
import com.Backend.SpendTrack.RecordatoriosCrud.Models.Recordatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }

    @GetMapping("/{clienteId}/presupuestos")
    public List<Presupuesto> getPresupuestosByClienteId(@PathVariable Long clienteId) {
        return clienteService.getPresupuestosByClienteId(clienteId);
    }

    @GetMapping("/{clienteId}/gastos")
    public List<Gastos> getGastosByClienteId(@PathVariable Long clienteId) {
        return clienteService.getGastoByClienteId(clienteId);
    }

    @GetMapping("/{clienteId}/recordatorios")
    public List<Recordatorio> getRecordatorioByClienteId(@PathVariable Long clienteId) {
        return clienteService.getRecordatorioByClienteId(clienteId);
    }

    @PostMapping(path = "/login/{correo}/{password}")
    public Cliente ValidarLogin(@PathVariable("correo") String correo, @PathVariable("password") String password){
        return clienteService.ValidarLogin(correo,password);
    }
}
