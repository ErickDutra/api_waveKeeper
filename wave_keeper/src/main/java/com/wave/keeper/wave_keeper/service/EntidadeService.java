package com.wave.keeper.wave_keeper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.dto.EntidadeDto;
import com.wave.keeper.wave_keeper.repository.EntidadeRepository;
import com.wave.keeper.wave_keeper.tables.Entidade;

@Service
public class EntidadeService {
    
    
    private final EntidadeRepository entidadeRepository;

    public EntidadeService(EntidadeRepository entidadeRepository) {
        this.entidadeRepository = entidadeRepository;
    }

    public EntidadeDto saveEntidade(EntidadeDto entidade) {
        Entidade entidadeEntity = new Entidade();
        entidadeEntity.setTitulo(entidade.titulo());
        entidadeEntity.setUrl(entidade.url());
        entidadeEntity.setProprietario(entidade.proprietario());
        Entidade entidadeDb = entidadeRepository.save(entidadeEntity);
        return new EntidadeDto(entidadeDb.getId(), entidadeDb.getTitulo(), entidadeDb.getUrl(), entidadeDb.getProprietario(), entidadeDb.getDateRegister());
    }

    public EntidadeDto getEntidadeById(Long id) {
        Entidade entidadeDb = entidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Entidade não encontrada para ID: " + id));
        return new EntidadeDto(entidadeDb.getId(), entidadeDb.getTitulo(), entidadeDb.getUrl(), entidadeDb.getProprietario(), entidadeDb.getDateRegister());
    }

    public List<EntidadeDto> getAllEntidades() {
        return entidadeRepository.findAll().stream()
        .map(entidade -> new EntidadeDto(entidade.getId(), entidade.getTitulo(), entidade.getUrl(), entidade.getProprietario(), entidade.getDateRegister())).toList();
    }

    public EntidadeDto updateEntidade(EntidadeDto entidade) {
        Entidade entidadeDb = entidadeRepository.findById(entidade.id()).orElseThrow(() -> new RuntimeException("Entidade não encontrada para ID: " + entidade.id()));
        entidadeDb.setTitulo(entidade.titulo());
        entidadeDb.setUrl(entidade.url());
        entidadeDb.setProprietario(entidade.proprietario());
        Entidade entidadeUpdate = entidadeRepository.save(entidadeDb);
        return new EntidadeDto(entidadeUpdate.getId(), entidadeUpdate.getTitulo(), entidadeUpdate.getUrl(), entidadeUpdate.getProprietario(), entidadeUpdate.getDateRegister());
    }

    public void deleteEntidade(Long id) {
        Entidade entidadeDb = entidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Entidade não encontrada para ID: " + id));
        entidadeRepository.delete(entidadeDb);
    }
}
