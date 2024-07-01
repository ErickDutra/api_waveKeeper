package com.wave.keeper.wave_keeper.dto;

import java.util.Set;

import com.wave.keeper.wave_keeper.tables.Usuario;

public record ContatoDto(Long id, Integer numero, Integer sufixo, Integer DDD, Set<Usuario> usuarios) {
    
}
