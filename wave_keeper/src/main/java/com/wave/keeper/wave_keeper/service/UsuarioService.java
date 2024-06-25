package com.wave.keeper.wave_keeper.service;

import com.wave.keeper.wave_keeper.dto.UsuarioDto;
import com.wave.keeper.wave_keeper.repository.UsuarioRepository;
import com.wave.keeper.wave_keeper.tables.Contato;
import com.wave.keeper.wave_keeper.tables.Endereco;
import com.wave.keeper.wave_keeper.tables.Usuario;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService{

    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDto> getUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioDto(usuario.getId(), usuario.getNome(), usuario.getCpf_cnpj(), usuario.getEmail(), usuario.getEndereco(), usuario.getContato()))
                .toList();
    }

    public UsuarioDto getUsuario(Long id) {
        Usuario usuarioDb = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        return new UsuarioDto(usuarioDb.getId(), usuarioDb.getNome(), usuarioDb.getCpf_cnpj(), usuarioDb.getEmail(), usuarioDb.getEndereco(), usuarioDb.getContato());
    }

    public UsuarioDto  saveUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.nome());
        usuario.setCpf_cnpj(usuarioDto.cpfCnpj());
        usuario.setEmail(usuarioDto.email());
        usuario.setEndereco(endereco);
        usuario.getContato().setNumero(contato.getNumero());
        usuario.getContato().setSufixo(contato.getSufixo());
        usuario.getContato().setDDD(contato.getDDD());
        Endereco endereco = new Endereco();

        Usuario usuarioDb = usuarioRepository.save(usuario);

        return new UsuarioDto(usuarioDb.getId(), usuarioDb.getNome(), usuarioDb.getCpf_cnpj(), usuarioDb.getEmail(), usuarioDb.getEndereco(), usuarioDb.getContato());
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioDto updateUsuario(Long id, UsuarioDto usuarioDto) {
        final Usuario usuario = usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        usuario.setNome(usuarioDto.nome());
        usuario.setCpf_cnpj(usuarioDto.cpfCnpj());
        usuario.setEmail(usuarioDto.email());
        usuario.setEndereco(endereco);
        usuario.getContato().setNumero(contato.getNumero());
        usuario.getContato().setSufixo(contato.getSufixo());
        usuario.getContato().setDDD(contato.getDDD());
        return new UsuarioDto(usuario.getId(), usuario.getNome(), usuario.getCpf_cnpj(), usuario.getEmail(), usuario.getEndereco(), usuario.getContato());
    }
    
}