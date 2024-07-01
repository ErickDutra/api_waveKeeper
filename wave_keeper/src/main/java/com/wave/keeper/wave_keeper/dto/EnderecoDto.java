package com.wave.keeper.wave_keeper.dto;

import java.util.Set;

import com.wave.keeper.wave_keeper.tables.Pais;
import com.wave.keeper.wave_keeper.tables.Usuario;

public record EnderecoDto(Long id, String rua, Integer numero, Long logradouro, String cidade, String estado, Pais pais, Set<Usuario> usuarios) {
}

