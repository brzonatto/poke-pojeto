package com.dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonEntity {
    private Integer idPokemon;
    private Integer numero;
    private String nome;
    private Integer level;
    private Double peso;
    private Double altura;
    private String categoria;
    private String regiaoDominante;
    private StatusEntity status;
}
