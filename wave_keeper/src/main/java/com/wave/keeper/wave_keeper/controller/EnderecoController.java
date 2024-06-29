package com.wave.keeper.wave_keeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave.keeper.wave_keeper.dto.EnderecoDto;
import com.wave.keeper.wave_keeper.service.EnderecoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @GetMapping
    public EnderecoDto getEndereco(@PathVariable Long id) {
        return enderecoService.getEnderecoById(id);
    }

    @PostMapping
    public EnderecoDto createEndereco(@RequestBody EnderecoDto endereco) {
        return enderecoService.saveEndereco(endereco);
    }
    @GetMapping("/all")
    public List<EnderecoDto> getAllEnderecos() {
        return enderecoService.getAllEnderecos();
    }

    @PutMapping("/{id}")
    public EnderecoDto updateEndereco(@PathVariable Long id, @RequestBody EnderecoDto endereco) {
        return enderecoService.updateEndereco(id, endereco);
    }

    @DeleteMapping("/{id}")
    public  void deleteEndereco(@PathVariable Long id) {
        enderecoService.deleteEndereco(id);
    }

}
