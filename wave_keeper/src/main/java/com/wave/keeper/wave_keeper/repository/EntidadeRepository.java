package com.wave.keeper.wave_keeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wave.keeper.wave_keeper.tables.Entidade;


public interface EntidadeRepository extends JpaRepository<Entidade, Long>{
    
}
