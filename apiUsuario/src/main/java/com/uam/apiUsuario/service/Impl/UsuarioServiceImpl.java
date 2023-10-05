package com.uam.apiUsuario.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uam.apiUsuario.model.Usuario;
import com.uam.apiUsuario.repository.UsuarioRepository;
import com.uam.apiUsuario.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuario() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(String id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isPresent()) {
            usuarioRepository.deleteById(id);
        } 
    }

    @Override
    public Usuario updateUsuario(String id, Usuario usuario) {
    	Usuario usuarioVar = usuarioRepository.findById(id).get();

       

            if (usuario.getNombre() != null) {
                usuarioVar.setNombre(usuario.getNombre());
            }
            if (usuario.getTelefono() != null) {
                usuarioVar.setTelefono(usuario.getTelefono());
            }
            if (usuario.getEmail() != null) {
                usuarioVar.setEmail(usuario.getEmail());
            }
            if (usuario.getDireccion() != null) {
                usuarioVar.setDireccion(usuario.getDireccion());
            }

            usuarioRepository.save(usuarioVar);
            return usuarioVar;
       
    }

    @Override
    public Usuario findById(String id) {
    	return usuarioRepository.findById(id).orElse(null);
    }
}
