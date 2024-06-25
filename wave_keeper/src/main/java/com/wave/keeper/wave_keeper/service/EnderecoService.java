package com.wave.keeper.wave_keeper.service;

import java.util.List;
import com.wave.keeper.wave_keeper.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.tables.Endereco;

@Service
public class EnderecoService{
    
    private final EnderecoRepository EnderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
    this.EnderecoRepository = enderecoRepository;
    }
 
    public List<Endereco> getAllEnderecos() {
        return EnderecoRepository.findAll();
    }

    public Endereco getEnderecoById(Long id) {
        return EnderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereco não encontrado"));
    }  

    public Endereco saveEndereco(Endereco Endereco) {
        return EnderecoRepository.save(Endereco);
    }

    public void deleteEndereco(Long id) {
        EnderecoRepository.deleteById(id);
    }

    public Endereco updateEndereco(Long id, Endereco Endereco) {
        Endereco EnderecoToUpdate = getEnderecoById(id);
        EnderecoToUpdate.setRua(Endereco.getRua());
        EnderecoToUpdate.setNumero(Endereco.getNumero());
        EnderecoToUpdate.setLogradouro(Endereco.getLogradouro());
        EnderecoToUpdate.setCidade(Endereco.getCidade());
        EnderecoToUpdate.setEstado(Endereco.getEstado());
        EnderecoToUpdate.setPais(Endereco.getPais());
        return EnderecoRepository.save(EnderecoToUpdate);
    }
}
