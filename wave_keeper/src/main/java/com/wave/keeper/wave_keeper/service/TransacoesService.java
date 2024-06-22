package com.wave.keeper.wave_keeper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.repository.TransacoesRepository;
import com.wave.keeper.wave_keeper.tables.Transacoes;

@Service
public class TransacoesService {

    private final TransacoesRepository transacoesRepository;

    public TransacoesService(TransacoesRepository transacoesRepository) {
        this.transacoesRepository = transacoesRepository;
    }

    public Transacoes criarTransacao(Transacoes transacao) {
        return transacoesRepository.save(transacao);
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
