package com.uam.apiUsuario.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.uam.apiUsuario.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository <Usuario, Long>{

	Optional<Usuario> findById(String id);
	void deleteById(String id);
}