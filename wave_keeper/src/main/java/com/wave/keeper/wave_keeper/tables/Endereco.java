package com.wave.keeper.wave_keeper.tables;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "endereco")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "rua", nullable = false, length = 150)
    private String rua;

    @Column(name = "numero", nullable = false, length = 10)
    private Integer numero;

    @Column(name = "logradouro", nullable = false, length = 150)
    private Long logradouro;

    @Column(name = "cidade", nullable = false, length = 150)
    private String cidade;

    @Column(name = "estado", nullable = false, length = 150)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

}
