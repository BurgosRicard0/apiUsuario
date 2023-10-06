package com.uam.apiUsuario.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.uam.apiUsuario.repository.UsuarioRepository;

import com.uam.apiUsuario.model.Usuario;


@Service
public interface UsuarioService {
	
	public List<Usuario> getUsuario();
    
    public Usuario addUsuario(Usuario usuario);

    public Usuario deleteUsuario(Long id );
    public Usuario findById(Long id);

    public Usuario updateUsuario(Long id , Usuario usuario);
	
}