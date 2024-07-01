package com.wave.keeper.wave_keeper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.dto.ContatoDto;
import com.wave.keeper.wave_keeper.repository.ContatoRepository;
import com.wave.keeper.wave_keeper.tables.Contato;

import jakarta.persistence.EntityNotFoundException;




@Service
public class ContatoService {
    
    @Autowired
    private final ContatoRepository contatoRepository;


    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public List<ContatoDto> getContatos() {
        return contatoRepository.findAll().stream()
                .map(contato -> new ContatoDto(contato.getId(), contato.getNumero(), contato.getDDD(), contato.getSufixo(), contato.getUsuarios()))
                .toList();
    }

    public ContatoDto getContato(Long id) {
         Contato contatoDb = contatoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contato não encontrado para ID: " + id));
        return new ContatoDto(contatoDb.getId(), contatoDb.getNumero(), contatoDb.getDDD(), contatoDb.getSufixo(), contatoDb.getUsuarios());
    }

    public ContatoDto saveContato(ContatoDto contatoDto) {
        Contato contato = new Contato();
        contato.setNumero(contatoDto.numero());
        contato.setSufixo(contatoDto.sufixo());
        contato.setDDD(contatoDto.DDD());
        

        Contato contatoDb = contatoRepository.save(contato);
        return new ContatoDto(contatoDb.getId(),contatoDb.getNumero(), contatoDb.getSufixo(), contatoDb.getDDD(), contatoDb.getUsuarios());
    }

    public void deleteContato(ContatoDto contatoDto) {
        Contato contato = contatoRepository.findById(contatoDto.id())
                .orElseThrow(() -> new EntityNotFoundException("Contato não encontrado para ID: " + contatoDto.id()));
        contatoRepository.delete(contato);
    }

    public ContatoDto updateContato(ContatoDto contatoDto) {
        Contato contato = contatoRepository.findById(contatoDto.id())
                .orElseThrow(() -> new EntityNotFoundException("Contato não encontrado para ID: " + contatoDto.id()));
    
        contato.setNumero(contatoDto.numero());
        contato.setDDD(contatoDto.DDD());
        contato.setSufixo(contatoDto.sufixo());
    
        Contato updatedContato = contatoRepository.save(contato);
        return new ContatoDto(updatedContato.getId(), updatedContato.getNumero(), updatedContato.getDDD(), updatedContato.getSufixo(), updatedContato.getUsuarios());
    }

}
