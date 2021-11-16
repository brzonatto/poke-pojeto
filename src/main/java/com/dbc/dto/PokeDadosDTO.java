package com.dbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokeDadosDTO {
    private PokemonCreateDTO pokemon;
    private List<TipoPokemonCreateDTO> tipos;
    private List<HabilidadeCreateDTO> habilidades;
    private EvolucaoNomesDTO evolucao;
}
