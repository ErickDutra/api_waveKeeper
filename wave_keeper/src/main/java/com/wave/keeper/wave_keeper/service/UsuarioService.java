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

    public UsuarioDto saveUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        Endereco enderecoDto = usuarioDto.endereco();
        Contato contatoDto = usuarioDto.contato();

        usuario.setNome(usuarioDto.nome());
        usuario.setCpf_cnpj(usuarioDto.cpf_cnpj());
        usuario.setEmail(usuarioDto.email());
        
        Contato contato = usuario.getContato();
        contato.setNumero(contatoDto.getNumero());
        contato.setSufixo(contatoDto.getSufixo());
        contato.setDDD(contatoDto.getDDD());
        usuario.setContato(contato);
        
        Endereco endereco = usuario.getEndereco();
        endereco.setNumero(enderecoDto.getNumero());
        endereco.setLogradouro(enderecoDto.getLogradouro());
        endereco.setCidade(enderecoDto.getCidade());
        endereco.setEstado(enderecoDto.getEstado());
        endereco.setRua(enderecoDto.getRua());

        Usuario usuarioDb = usuarioRepository.save(usuario);
      
        return new UsuarioDto(usuarioDb.getId(), usuarioDb.getNome(), usuarioDb.getCpf_cnpj(), usuarioDb.getEmail(), usuarioDb.getEndereco(), usuarioDb.getContato());
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

        Endereco enderecoDto = usuarioDto.endereco();
        Contato contatoDto = usuarioDto.contato();

        Endereco endereco = usuario.getEndereco();

        endereco.setNumero(enderecoDto.getNumero());
        endereco.setLogradouro(enderecoDto.getLogradouro());
        endereco.setCidade(enderecoDto.getCidade());
        endereco.setEstado(enderecoDto.getEstado());
        endereco.setRua(enderecoDto.getRua());

        Contato contato = usuario.getContato();
        contato.setNumero(contatoDto.getNumero());
        contato.setSufixo(contatoDto.getSufixo());
        contato.setDDD(contatoDto.getDDD());

        usuarioRepository.save(usuario);

        return new UsuarioDto(
                usuario.getId(), 
                usuario.getNome(), 
                usuario.getCpf_cnpj(), 
                usuario.getEmail(), 
                usuario.getEndereco(), 
                usuario.getContato()
        );
    }
    
}