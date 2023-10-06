package com.uam.apiUsuario.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uam.apiUsuario.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	@Query("SELECT new com.uam.apiUsuario.model.Usuario(u.id, u.nombre, u.email) FROM Usuario u")
    List<Usuario> findAll();
    

}