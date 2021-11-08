package com.dbc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvolucaoDTO {
    private Integer idEvolucao;

    @ApiModelProperty("Estágio básico Pokémon")
    @NotNull
    private PokemonDTO estagioUm;

    @ApiModelProperty("Primeira Evolução")
    @NotNull
    private PokemonDTO estagioDois;

    @ApiModelProperty("Segunda Evolução")
    private PokemonDTO estagioTres;
}
