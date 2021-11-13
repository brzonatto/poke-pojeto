package com.dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pokemon_habilidade")
public class HabilidadePokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_habilidadepoke")
    @SequenceGenerator(name = "seq_id_habilidadepoke", sequenceName = "seq_id_habilidadepoke", allocationSize = 1)
    @Column(name = "id_habilidadepoke")
    private Integer idHabilidadePokemonEntity;

    @ManyToOne
    @MapsId("fk_habilidade_id_habilidade")
    private HabilidadeEntity habilidade;

    @ManyToOne
    @MapsId("fk_pokemon_id_pokemon")
    private PokemonEntity pokemon;

//    @Column(name = "fk_habilidade_id_habilidade")
//    private Integer idHabilidadePokemon;
//    private PokemonEntity pokemon;
//    private List<HabilidadeEntity> habilidadeEntityList;
}
