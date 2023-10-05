package com.uam.apiUsuario.model;

import java.util.List; // Importa la clase List correcta desde java.util


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre ;
    private String contraseña;
    private String direccion;
    private String telefono;
    private String email;
    
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Reservacion> reservaciones;
    
}