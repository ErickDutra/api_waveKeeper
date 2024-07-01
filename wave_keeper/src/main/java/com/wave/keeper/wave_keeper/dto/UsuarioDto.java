package com.wave.keeper.wave_keeper.dto;

import java.util.Date;

public record UsuarioDto(Long id, String nome, String cpf_cnpj, String email, String senha, Date dateRegistered) {
}
