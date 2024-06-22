package com.wave.keeper.wave_keeper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.repository.ContatoRepository;
import com.wave.keeper.wave_keeper.tables.Contato;




@Service
public class ContatoService {
    
    private final ContatoRepository contatoRepository;


    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public List<Contato> getContatos() {
        return contatoRepository.findAll();
    }

    public Contato getContato(Long id) {
        return contatoRepository.findById(id).orElse(null);
    }

    public Contato saveContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    public void deleteContato(Long id) {
        contatoRepository.deleteById(id);
    }

    public Contato updateContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    

}
