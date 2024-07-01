package com.wave.keeper.wave_keeper.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wave.keeper.wave_keeper.tables.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}