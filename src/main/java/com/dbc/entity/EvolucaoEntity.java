package com.dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvolucaoEntity {
    private Integer idEvolucao;
    private PokemonEntity estagioUm;
    private PokemonEntity estagioDois;
    private PokemonEntity estagioTres;
}
