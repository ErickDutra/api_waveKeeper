package com.wave.keeper.wave_keeper.dto;

import java.util.Date;

public record TransacoesDto(Long id, Double valor,EntidadeDto entidade,UsuarioDto vendedor,UsuarioDto comprador, Date dateTransacao) {

}
