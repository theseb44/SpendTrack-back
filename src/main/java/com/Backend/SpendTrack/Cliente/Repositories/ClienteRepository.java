package com.Backend.SpendTrack.Cliente.Repositories;

import com.Backend.SpendTrack.Cliente.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCorreoAndPassword(String correo, String contraseña);
}
