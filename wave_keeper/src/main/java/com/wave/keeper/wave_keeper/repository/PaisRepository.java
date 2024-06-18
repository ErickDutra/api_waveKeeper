package com.wave.keeper.wave_keeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wave.keeper.wave_keeper.tables.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
    
}
