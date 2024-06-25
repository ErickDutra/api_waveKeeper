package com.wave.keeper.wave_keeper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.repository.EntidadeRepository;
import com.wave.keeper.wave_keeper.tables.Entidade;

@Service
public class EntidadeService {
    
    
    private final EntidadeRepository entidadeRepository;

    public EntidadeService(EntidadeRepository entidadeRepository) {
        this.entidadeRepository = entidadeRepository;
    }

    public Entidade saveEntidade(Entidade Entidade) {
        return entidadeRepository.save(Entidade);
    }

    public Entidade getEntidadeById(Long id) {
        return entidadeRepository.findById(id).orElse(null);
    }

    public List<Entidade> getAllEntidades() {
        return entidadeRepository.findAll();
    }

    public Entidade updateEntidade(Entidade Entidade) {
        return entidadeRepository.save(Entidade);
    }

    public void deleteEntidade(Long id) {
        entidadeRepository.deleteById(id);
    }
}
