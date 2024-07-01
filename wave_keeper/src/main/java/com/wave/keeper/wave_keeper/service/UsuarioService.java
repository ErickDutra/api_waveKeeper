package com.wave.keeper.wave_keeper.service;

import com.wave.keeper.wave_keeper.dto.UsuarioDto;
import com.wave.keeper.wave_keeper.repository.UsuarioRepository;
import com.wave.keeper.wave_keeper.tables.Usuario;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioService{

    @Autowired
    private  UsuarioRepository usuarioRepository;

    public List<UsuarioDto> getUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioDto(usuario.getId(), usuario.getNome(), usuario.getCpf_cnpj(), usuario.getEmail(), usuario.getSenha(), usuario.getDateRegister()))
                .toList();
    }

    public UsuarioDto getUsuario(Long id) {
        Usuario usuarioDb = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        return new UsuarioDto(usuarioDb.getId(), usuarioDb.getNome(), usuarioDb.getCpf_cnpj(), usuarioDb.getEmail(), usuarioDb.getSenha(), usuarioDb.getDateRegister());
    }

    public UsuarioDto saveUsuario(UsuarioDto usuarioDto) {

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.nome());
        usuario.setCpf_cnpj(usuarioDto.cpf_cnpj());
        usuario.setEmail(usuarioDto.email());
        usuario.setSenha(usuarioDto.senha());
        usuario.setDateRegister(Date.from(Instant.now()));
        Usuario usuarioDb = usuarioRepository.save(usuario);

        return new UsuarioDto(usuarioDb.getId(), usuarioDb.getNome(), usuarioDb.getCpf_cnpj(), usuarioDb.getEmail(), usuarioDb.getSenha(), usuarioDb.getDateRegister());
    }

    public void deleteUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findById(usuarioDto.id())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + usuarioDto.id()));
        usuarioRepository.delete(usuario);
    }

    public UsuarioDto updateUsuario(Long id, UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        usuario.setNome(usuarioDto.nome());
        usuario.setCpf_cnpj(usuarioDto.cpf_cnpj());
        usuario.setEmail(usuarioDto.email());
        usuario.setSenha(usuarioDto.senha());
        usuario.setDateRegister(Date.from(Instant.now()));
        usuarioRepository.save(usuario);

        return new UsuarioDto(
                usuario.getId(), 
                usuario.getNome(), 
                usuario.getCpf_cnpj(), 
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getDateRegister()
        );
    }
    
}