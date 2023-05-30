package com.Backend.SpendTrack.Admin;

import com.Backend.SpendTrack.Usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "admins")
public class Admin extends Usuario {
}
