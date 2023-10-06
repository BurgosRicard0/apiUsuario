package com.uam.apiUsuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uam.apiUsuario.model.Usuario;
import com.uam.apiUsuario.repository.UsuarioRepository;
import com.uam.apiUsuario.service.UsuarioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
	@Override
	public Usuario deleteUsuario(Long id) {
		Optional<Usuario> usuarioOp= usuarioRepository.findById(id);
		if (usuarioOp.isPresent()) {
            Usuario usuario = usuarioOp.get();
            usuarioRepository.delete(usuario);
            return usuario;
		} else {
            return null;
        }
	}
	@Override
	public Usuario findById(Long id) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		return optionalUsuario.get();
	}

	@Override
	public Usuario updateUsuario(Long id, Usuario usuario) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario existingUsuario = usuarioOptional.get();
            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setDireccion(usuario.getDireccion());
            existingUsuario.setTelefono(usuario.getTelefono());
            existingUsuario.setEmail(usuario.getEmail());
            return usuarioRepository.save(existingUsuario);
        } else {
            return null; 
        }
	}
}
