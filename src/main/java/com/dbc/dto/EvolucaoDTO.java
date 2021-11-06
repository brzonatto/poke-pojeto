package com.dbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvolucaoDTO {
    private Integer idEvolucao;
    private PokemonDTO estagioUm;
    private PokemonDTO estagioDois;
    private PokemonDTO estagioTres;
}
