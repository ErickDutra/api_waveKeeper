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

    public TransacoesDto criarTransacao(Transacoes transacao) {
        Transacoes transacoes = new Transacoes();
        Entidade entidadeDto = transacao.getEntidade();
        Entidade entidade = transacoes.getEntidade();
        
        transacoes.setValor(transacao.getValor());
        entidade.setId(entidadeDto.getId());
        transacoes.setEntidade(entidade);
        transacoes.setVendedor(transacao.getVendedor());
        transacoes.setComprador(transacao.getComprador());
        transacoes.setDateTransacao(transacao.getDateTransacao());

        Transacoes transacaoDb = transacoesRepository.save(transacoes);
        return new TransacoesDto(transacaoDb.getId(), transacaoDb.getValor(), transacaoDb.getEntidade(), transacaoDb.getVendedor(), transacaoDb.getComprador(), transacaoDb.getDateTransacao());
        
    }

    public Transacoes buscarTransacaoPorId(Long id) {
        return transacoesRepository.findById(id).orElse(null);
    }

    public List<Transacoes> buscarTodasTransacoes() {
        return transacoesRepository.findAll();
    }

    public Transacoes atualizarTransacao(Transacoes transacao) {
        return transacoesRepository.save(transacao);
    }

    public void deletarTransacao(Long id) {
        transacoesRepository.deleteById(id);
    }
}
