package com.wave.keeper.wave_keeper.service;

import com.wave.keeper.wave_keeper.repository.UsuarioRepository;
import com.wave.keeper.wave_keeper.tables.Usuario;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService{

    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}