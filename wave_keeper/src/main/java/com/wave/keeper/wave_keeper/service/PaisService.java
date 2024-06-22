package com.wave.keeper.wave_keeper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.repository.PaisRepository;
import com.wave.keeper.wave_keeper.tables.Pais;

@Service
public class PaisService {
    
    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
    this.paisRepository = paisRepository;
    }

    
    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }

    public Pais getPaisById(Long id) {
        return paisRepository.findById(id).orElseThrow(() -> new RuntimeException("Pais não encontrado"));
    }  

    public Pais savePais(Pais pais) {
        return paisRepository.save(pais);
    }

    public void deletePais(Long id) {
        paisRepository.deleteById(id);
    }

    public Pais updatePais(Long id, Pais pais) {
        Pais paisToUpdate = getPaisById(id);
        paisToUpdate.setNome(pais.getNome());
        paisToUpdate.setSigla(pais.getSigla());
        return paisRepository.save(paisToUpdate);
    }

    



}
