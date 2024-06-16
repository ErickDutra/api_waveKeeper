package com.wave.keeper.wave_keeper.tables;


import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "Endereco")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "rua", nullable = false, length = 150)
    private String rua;

    @Column(name = "numero", nullable = false, length = 10)
    private Integer numero;

    @Column(name = "bairro", nullable = false, length = 150)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = 150)
    private String cidade;

    @Column(name = "estado", nullable = false, length = 150)
    private String estado;

    @ManyToAny
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

}
