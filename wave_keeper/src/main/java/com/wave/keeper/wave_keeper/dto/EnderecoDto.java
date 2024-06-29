package com.wave.keeper.wave_keeper.dto;

import com.wave.keeper.wave_keeper.tables.Pais;

public record EnderecoDto(Long id, String rua, Integer numero, Long logradouro, String cidade, String estado, Pais pais) {
}

