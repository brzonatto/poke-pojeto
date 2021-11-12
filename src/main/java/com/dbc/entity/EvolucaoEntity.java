package com.dbc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "evolucao")
public class EvolucaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_evolucao")
    @SequenceGenerator(name = "seq_id_evolucao", sequenceName = "seq_id_evolucao", allocationSize = 1)
    @Column(name = "id_evolucao")
    private Integer idEvolucao;


    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id_poke_estagio_1_evolucao", referencedColumnName = "id_pokemon")
    private PokemonEntity estagioUm;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id_poke_estagio_2_evolucao", referencedColumnName = "id_pokemon")
    private PokemonEntity estagioDois;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_poke_estagio_3_evolucao", referencedColumnName = "id_pokemon")
    @JsonIgnore
    private PokemonEntity estagioTres; 
}
