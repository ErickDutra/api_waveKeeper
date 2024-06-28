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

    public Pais savePais(Pais pais) {
        return paisRepository.save(pais);
    }

    public void deletePais(Long id) {
        Pais paisDb = paisRepository.findById(id).orElseThrow(() -> new RuntimeException("Pais não encontrado para ID:"+ id));
        paisRepository.delete(paisDb);
    }

    public Pais updatePais(Long id, Pais pais) {
        Pais paisToUpdate = getPaisById(id);
        paisToUpdate.setNome(pais.getNome());
        paisToUpdate.setSigla(pais.getSigla());
        return paisRepository.save(paisToUpdate);
    }

    



}
