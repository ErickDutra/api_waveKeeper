package com.wave.keeper.wave_keeper.dto;

import com.wave.keeper.wave_keeper.tables.Contato;
import com.wave.keeper.wave_keeper.tables.Endereco;

public record UsuarioDto(Long id, String nome, String cpf_cnpj, String email, Endereco endereco, Contato contato) {
}
