package com.wave.keeper.wave_keeper.dto;

import java.util.Date;

import com.wave.keeper.wave_keeper.tables.Usuario;

public record EntidadeDto(Long id, String titulo, String url, Usuario proprietario, Date dateRegister) {
    
}
