package com.uam.apiUsuario.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mas campos de la reservación

    @ManyToOne
    private Usuario usuario;

    // Getters y setters

    // Otros campos y métodos
}
