package com.wave.keeper.wave_keeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave.keeper.wave_keeper.dto.ContatoDto;
import com.wave.keeper.wave_keeper.service.ContatoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping("/{id}")
    public ContatoDto getContato(@PathVariable Long id) {
            return contatoService.getContato(id);
    }
    
    @GetMapping
    public List<ContatoDto> getAllContatos() {
        return contatoService.getContatos();
    }
    
    @PostMapping
    public ContatoDto createContato(@RequestBody ContatoDto contato) {
        return contatoService.saveContato(contato);
    }
    
    @PutMapping("/{id}")
    public ContatoDto  updateContato(@PathVariable Long id, @RequestBody ContatoDto contato) {
        return contatoService.updateContato(contato);
    }
    
    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable ContatoDto contato) {
        contatoService.deleteContato(contato);
    }
}
