package com.wave.keeper.wave_keeper.dto;

import java.util.Date;

public record RightDto(Long id, EntidadeDto entidade, UsuarioDto vendedor, Date dateStart, Date dateOver) {
    
}
