package com.wave.keeper.wave_keeper.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave.keeper.wave_keeper.dto.EntidadeDto;
import com.wave.keeper.wave_keeper.service.EntidadeService;



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
    public EntidadeDto saveEntidade(@RequestParam EntidadeDto entidade) {
        return entidadeService.saveEntidade(entidade);
    }
    @GetMapping("/{id}")
    public EntidadeDto getEntidadeById(@RequestParam Long Id) {
        return entidadeService.getEntidadeById(Id);
    }
     
    @GetMapping("/all")
    public List<EntidadeDto>getAllEntidades() {
        return getAllEntidades();
    }

    @PutMapping("/{id}")
    public EntidadeDto updateEntidade(@PathVariable Long id, @RequestBody EntidadeDto entidade) {
        return updateEntidade(id, entidade);
    }

    @DeleteMapping ("/{id}")
    public void deleteEntidade(@PathVariable Long id) {
        deleteEntidade(id);
    }


}