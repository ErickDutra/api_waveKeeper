package com.wave.keeper.wave_keeper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.dto.TransacoesDto;
import com.wave.keeper.wave_keeper.repository.TransacoesRepository;
import com.wave.keeper.wave_keeper.tables.Entidade;
import com.wave.keeper.wave_keeper.tables.Transacoes;


@Service
public class TransacoesService {

    private final TransacoesRepository transacoesRepository;

    public TransacoesService(TransacoesRepository transacoesRepository) {
        this.transacoesRepository = transacoesRepository;
    }

    public TransacoesDto criarTransacao(TransacoesDto transacao) {
        Transacoes transacoes = new Transacoes();
        Entidade entidadeDto = transacoes.getEntidade();
        Entidade entidade = transacoes.getEntidade();
        
        transacoes.setValor(transacoes.getValor());
        entidade.setId(entidadeDto.getId());
        transacoes.setEntidade(entidade);
        transacoes.setVendedor(transacoes.getVendedor());
        transacoes.setComprador(transacoes.getComprador());
        transacoes.setDateTransacao(transacoes.getDateTransacao());

        Transacoes transacaoDb = transacoesRepository.save(transacoes);
        return new TransacoesDto(transacaoDb.getId(), transacaoDb.getValor(), transacaoDb.getEntidade(), transacaoDb.getVendedor(), transacaoDb.getComprador(), transacaoDb.getDateTransacao());
        
    }

    public TransacoesDto buscarTransacaoPorId(Long id) {
        Transacoes transacoesDB = transacoesRepository.findById(id).orElseThrow(() -> new RuntimeException("Transação não encontrada para ID: " + id));
        return new TransacoesDto(transacoesDB.getId(), transacoesDB.getValor(), transacoesDB.getEntidade(), transacoesDB.getVendedor(), transacoesDB.getComprador(), transacoesDB.getDateTransacao());
    }

    public List<TransacoesDto> buscarTodasTransacoes() {
        return transacoesRepository.findAll().stream().map(trasacoes -> new TransacoesDto(trasacoes.getId(), trasacoes.getValor(), trasacoes.getEntidade(), trasacoes.getVendedor(), trasacoes.getComprador(), trasacoes.getDateTransacao())).toList();
    }

    public TransacoesDto atualizarTransacao(Long id,TransacoesDto transacao) {
        Transacoes transacoesDb = transacoesRepository.findById(id).orElseThrow(() -> new RuntimeException("Transação não encontrada para ID: " + id));
        transacoesDb.setValor(transacao.valor());
        transacoesDb.setEntidade(transacao.entidade());
        transacoesDb.setVendedor(transacao.vendedor());
        transacoesDb.setComprador(transacao.comprador());
        transacoesDb.setDateTransacao(transacao.dateTransacao());

        return new TransacoesDto(transacoesDb.getId(), transacoesDb.getValor(), transacoesDb.getEntidade(), transacoesDb.getVendedor(), transacoesDb.getComprador(), transacoesDb.getDateTransacao());
    }

    public void deletarTransacao(TransacoesDto transacao) {
        Transacoes transacoesDb = transacoesRepository.findById(transacao.id()).orElseThrow(() -> new RuntimeException("Transação não encontrada para ID:" + transacao.id()));
        transacoesRepository.delete(transacoesDb);
        
    }
}
