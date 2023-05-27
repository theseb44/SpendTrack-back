package com.Backend.SpendTrack.Cliente.Controllers;

import com.Backend.SpendTrack.Cliente.Models.Cliente;
import com.Backend.SpendTrack.Cliente.Services.ClienteService;
import com.Backend.SpendTrack.Presupuesto.Models.Presupuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
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
}
