package com.wave.keeper.wave_keeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave.keeper.wave_keeper.dto.PaisDto;
import com.wave.keeper.wave_keeper.service.PaisService;
import com.wave.keeper.wave_keeper.tables.Pais;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@CrossOrigin("*")
@RequestMapping("/Pais")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping("/{id}")
    public Pais getPaisByIdPais(@RequestParam Long id) {
        return paisService.getPaisById(id);
    }
    
    @PutMapping("/{id}")
    public Pais updatePais(@PathVariable Long id, @RequestBody Pais pais) {
        return paisService.updatePais(id, pais);
        }

    @GetMapping("/all")
    public List<PaisDto> getAllPaises() {
        return paisService.getAllPaises();
    }

    @DeleteMapping("/{id}")
    public void deletePais(@PathVariable Long id) {
        paisService.deletePais(id);
    }   


    @PostMapping
    public Pais savePais(@RequestBody Pais pais) {
        return paisService.savePais(pais);
    }

}
