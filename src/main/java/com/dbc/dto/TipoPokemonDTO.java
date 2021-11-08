package com.dbc.dto;


import com.dbc.enums.Tipo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPokemonDTO {
    @ApiModelProperty("Id do tipo do Pokémon")
    private Integer idTipoPokemon;

    @ApiModelProperty("Id do Pokémon")
    private Integer idPokemon;

    @ApiModelProperty("Lista de tipos do Pokémon")
    private List<Tipo> tipo;
}
