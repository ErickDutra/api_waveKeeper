package com.wave.keeper.wave_keeper.dto;

import java.util.Date;

import com.wave.keeper.wave_keeper.tables.Entidade;
import com.wave.keeper.wave_keeper.tables.Usuario;

public record RightsDto(Long id, Entidade entidade, Usuario vendedor, Date dateStart, Date dateOver, Long price) {
    
}
