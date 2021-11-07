package com.dbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvolucaoDTO {
    private Integer idEvolucao;

    @NotNull
    private PokemonDTO estagioUm;

    @NotNull
    private PokemonDTO estagioDois;

    private PokemonDTO estagioTres;
}
