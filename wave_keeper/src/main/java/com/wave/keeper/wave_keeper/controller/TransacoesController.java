package com.wave.keeper.wave_keeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave.keeper.wave_keeper.dto.TransacoesDto;
import com.wave.keeper.wave_keeper.service.TransacoesService;

@RestController
@CrossOrigin("*")
@RequestMapping("/transacoes")
public class TransacoesController {
    
    @Autowired
    private TransacoesService transacoesService;

    @GetMapping("/{id}")
    public TransacoesDto getTransacoes(@PathVariable Long id){
        return transacoesService.buscarTransacaoPorId(id); 
    }

    @PostMapping
    public ResponseEntity<TransacoesDto> criarTransacao(@RequestBody TransacoesDto transacaoDto) {
    TransacoesDto novaTransacao = transacoesService.criarTransacao(transacaoDto);
    return new ResponseEntity<>(novaTransacao, HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<TransacoesDto> atualizarTransacao(@PathVariable Long id, @RequestBody TransacoesDto transacaoDto) {
    TransacoesDto transacaoAtualizada = transacoesService.atualizarTransacao(id, transacaoDto);
    return new ResponseEntity<>(transacaoAtualizada, HttpStatus.OK);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deletarTransacao(@PathVariable TransacoesDto transacaoDto) {
    transacoesService.deletarTransacao(transacaoDto);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
