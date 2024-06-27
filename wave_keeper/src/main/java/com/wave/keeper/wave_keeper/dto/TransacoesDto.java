package com.wave.keeper.wave_keeper.dto;

import java.util.Date;

import com.wave.keeper.wave_keeper.tables.Entidade;
import com.wave.keeper.wave_keeper.tables.Usuario;

public record TransacoesDto(Long id, Double valor,Entidade entidade,Usuario vendedor,Usuario comprador, Date dateTransacao) {

}
