package com.wave.keeper.wave_keeper.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contato")
public class Contato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "sufixo", nullable = false, length = 150)
    private Integer sufixo;

    @Column(name = "DDD", nullable = false, length = 14,unique = true)
    private Integer DDD;

    @Column(name = "Numero", nullable = false, length = 14,unique = true)
    private Integer numero;
}
