package com.wave.keeper.wave_keeper.dto;

import com.wave.keeper.wave_keeper.tables.Contato;

public record UsuarioDto (Long id, String nome, String cpfCnpj, String email, EnderecoDto endereco, Contato contato) {
}
