package com.wave.keeper.wave_keeper.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave.keeper.wave_keeper.service.EntidadeService;
import com.wave.keeper.wave_keeper.tables.Entidade;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin("*")
@RequestMapping("/Entidade")
public class EntidadeController {
    @Autowired
    private EntidadeService entidadeService;

    @PostMapping
    public Entidade saveEntidade(@RequestParam Entidade entidade) {
        return entidadeService.saveEntidade(entidade);
    }
    @GetMapping("/{id}")
    public Entidade getEntidadeById(@RequestParam Long Id) {
        return entidadeService.getEntidadeById(Id);
    }
     
    @GetMapping("/all")
    public List<Entidade>getAllEntidades() {
        return getAllEntidades();
    }

    @PutMapping("/{id}")
    public Entidade updateEntidade(@PathVariable Long id, @RequestBody Entidade entidade) {
        return updateEntidade(id, entidade);
    }

    @DeleteMapping ("/{id}")
    public void deleteEntidade(@PathVariable Long id) {
        deleteEntidade(id);
    }


    

    
    

}