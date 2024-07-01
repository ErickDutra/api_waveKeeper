package com.wave.keeper.wave_keeper.service;

import java.util.List;

import com.wave.keeper.wave_keeper.dto.EnderecoDto;
import com.wave.keeper.wave_keeper.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.tables.Endereco;
import com.wave.keeper.wave_keeper.tables.Pais;

@Service
public class EnderecoService{
    
    @Autowired
    private final EnderecoRepository EnderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
    this.EnderecoRepository = enderecoRepository;
    }
 
    public List<EnderecoDto> getAllEnderecos(){
        return EnderecoRepository.findAll().stream()
        .map(Endereco -> new EnderecoDto(Endereco.getId(), Endereco.getRua(), Endereco.getNumero(), Endereco.getZipcode(), Endereco.getCidade(), Endereco.getEstado(), Endereco.getPais(), Endereco.getUsuarios())).toList();
    }

    public EnderecoDto getEnderecoById(Long id) {
        Endereco EnderecoDb = EnderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereco não encontrado para ID: " + id));
        return new EnderecoDto(EnderecoDb.getId(), EnderecoDb.getRua(), EnderecoDb.getNumero(), EnderecoDb.getZipcode(), EnderecoDb.getCidade(), EnderecoDb.getEstado(), EnderecoDb.getPais(), EnderecoDb.getUsuarios());
    }  

    public EnderecoDto saveEndereco(EnderecoDto endereco) {
        Endereco enderecoEntity = new Endereco();
        Pais paisDto = endereco.pais();
        Pais pais = enderecoEntity.getPais();
        enderecoEntity.setRua(endereco.rua());
        enderecoEntity.setNumero(endereco.numero());
        enderecoEntity.setZipcode(endereco.logradouro());
        enderecoEntity.setCidade(endereco.cidade());
        enderecoEntity.setEstado(endereco.estado());
        pais.setNome(paisDto.getNome());
        pais.setSigla(paisDto.getSigla());
        enderecoEntity.setPais(pais);
        Endereco enderecoDb = EnderecoRepository.save(enderecoEntity);
        return new EnderecoDto(enderecoDb.getId(), enderecoDb.getRua(), enderecoDb.getNumero(), enderecoDb.getZipcode(), enderecoDb.getCidade(), enderecoDb.getEstado(), enderecoDb.getPais(), enderecoDb.getUsuarios());
    }

    public void deleteEndereco(Long id) {
        Endereco EnderecoDb = EnderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereco não encontrado para ID: " + id));
        EnderecoRepository.delete(EnderecoDb);
    }

    public EnderecoDto updateEndereco(Long id, EnderecoDto endereco) {
        Endereco enderecoDb = EnderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereco não encontrado para ID: " + id));
        enderecoDb.setRua(endereco.rua());
        enderecoDb.setNumero(endereco.numero());
        enderecoDb.setZipcode(endereco.logradouro());
        enderecoDb.setCidade(endereco.cidade());
        enderecoDb.setEstado(endereco.estado());
        enderecoDb.setPais(endereco.pais());
        Endereco enderecoUpdate = EnderecoRepository.save(enderecoDb);
        return new EnderecoDto(enderecoUpdate.getId(), enderecoUpdate.getRua(), enderecoUpdate.getNumero(), enderecoUpdate.getZipcode(), enderecoUpdate.getCidade(), enderecoUpdate.getEstado(), enderecoUpdate.getPais(), enderecoUpdate.getUsuarios());
    }
}
