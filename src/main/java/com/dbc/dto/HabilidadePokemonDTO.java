package com.dbc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadePokemonDTO {
    @ApiModelProperty("Id da Habilidade do Pokémon")
    private Integer idHabilidadePokemon;

    @ApiModelProperty("Id do pokémon que a habilidade está associada")
    private Integer idPokemon;

    @ApiModelProperty("Lista de Habilidades do pokémon")
    private List<HabilidadeDTO> habilidadeDTOListList;
}
