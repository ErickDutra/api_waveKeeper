package com.wave.keeper.wave_keeper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.repository.MusicaRepository;
import com.wave.keeper.wave_keeper.tables.Musica;

@Service
public class MusicaService {
    
    
    private final MusicaRepository musicaRepository;

    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    public Musica saveMusica(Musica musica) {
        return musicaRepository.save(musica);
    }

    public Musica getMusicaById(Long id) {
        return musicaRepository.findById(id).orElse(null);
    }

    public List<Musica> getAllMusicas() {
        return musicaRepository.findAll();
    }

    public Musica updateMusica(Musica musica) {
        return musicaRepository.save(musica);
    }

    public void deleteMusica(Long id) {
        musicaRepository.deleteById(id);
    }
}
