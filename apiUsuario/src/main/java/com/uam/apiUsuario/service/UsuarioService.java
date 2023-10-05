package com.uam.apiUsuario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uam.apiUsuario.model.Usuario;


@Service
public interface UsuarioService {
	
	public List<Usuario> getUsuario();
    
    public Usuario addUsuario(Usuario usuario);

    public void deleteUsuario(String id );
    public Usuario findById(String id);

    public Usuario updateUsuario(String id , Usuario usuario);
	
}