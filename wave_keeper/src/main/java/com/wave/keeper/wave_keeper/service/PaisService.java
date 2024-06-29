package com.wave.keeper.wave_keeper.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.dto.PaisDto;
import com.wave.keeper.wave_keeper.repository.PaisRepository;
import com.wave.keeper.wave_keeper.tables.Pais;

@Service
public class PaisService {
    
    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
    this.paisRepository = paisRepository;
    }

    
    public List<PaisDto> getAllPaises() {
        return paisRepository.findAll().stream()
        .map(pais -> new PaisDto(pais.getId(), pais.getNome(),pais.getSigla())).collect(Collectors.toList());
    }

    public PaisDto getPais(Long id) {
        Pais pais = paisRepository.findById(id).orElseThrow(() -> new RuntimeException("Pais não encontrado para ID: " + id));
        return new PaisDto(pais.getId(), pais.getNome(), pais.getSigla() );
    }

    public PaisDto savePais(PaisDto pais) {
        Pais paisEntity = new Pais();
        paisEntity.setNome(pais.nome());
        paisEntity.setSigla(pais.sigla());
        Pais paisDb = paisRepository.save(paisEntity);
        return new PaisDto(paisDb.getId(), paisDb.getNome(), paisDb.getSigla());
    }

    public void deletePais(Long id) {
        Pais paisDb = paisRepository.findById(id).orElseThrow(() -> new RuntimeException("Pais não encontrado para ID:"+ id));
        paisRepository.delete(paisDb);
    }

    public PaisDto updatePais(Long id, PaisDto paisdto) {
        final Pais pais = paisRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Pais não encontrado para ID: " + id));
        pais.setNome(paisdto.nome());
        pais.setSigla(paisdto.sigla());
        final Pais paisDb = paisRepository.save(pais);
        return new PaisDto(paisDb.getId(), paisDb.getNome(), paisDb.getSigla());
    }
}
