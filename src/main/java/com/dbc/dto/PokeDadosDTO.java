package com.dbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokeDadosDTO {
    private PokemonDTO pokemonDTO;
    private TipoPokemonDTO tipoPokemonDTO;
    private HabilidadePokemonDTO habilidadePokemonDTO;
    private EvolucaoDTO evolucaoDTO;
}
