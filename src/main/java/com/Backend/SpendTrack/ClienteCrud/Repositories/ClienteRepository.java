package com.Backend.SpendTrack.ClienteCrud.Repositories;

import com.Backend.SpendTrack.ClienteCrud.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCorreoAndPassword(String correo, String contraseña);
}
