package com.dbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokeDadosDTO {
    private PokemonCreateDTO pokemon;
    private TipoPokemonCreateDTO tipos;
    private HabilidadePokemonDTO habilidades;
    private EvolucaoNomesDTO evolucao;
}
