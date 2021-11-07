package com.dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadeEntity {
    private Integer idHabilidade;
    private String nome;
    private Double multiplicacaoDePoder;
    private PokemonEntity pokemon;
}
