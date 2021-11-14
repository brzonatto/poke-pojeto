package com.dbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonHabilidadeDTO {
    private PokemonDTO pokemon;
    private List<HabilidadeDTO> habilidades;
}
