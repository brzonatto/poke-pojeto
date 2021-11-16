package com.dbc.dto;


import com.dbc.enums.Tipo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPokemonDTO {
    @NotNull
    @ApiModelProperty("Id do tipo do Pokémon")
    private Integer idTipoPokemon;

    @NotNull
    @ApiModelProperty("Id do Pokémon")
    private Integer idPokemon;

    @NotNull
    @ApiModelProperty("Lista de tipos do Pokémon")
    private Tipo tipo;
}
