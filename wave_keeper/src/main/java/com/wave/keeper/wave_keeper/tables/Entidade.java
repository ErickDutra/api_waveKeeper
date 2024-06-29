package com.wave.keeper.wave_keeper.tables;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entidade")
public class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "Titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "Url", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "propietario_id", nullable = false)
    private Usuario proprietario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cadastro", nullable = false)
    private Date dateRegister;
}
