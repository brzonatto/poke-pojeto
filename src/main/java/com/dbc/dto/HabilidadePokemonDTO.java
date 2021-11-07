package com.dbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadePokemonDTO {
    private Integer idHabilidadePokemon;
    private Integer idPokemon;
    private List<HabilidadeDTO> habilidadeEntityList;
}
