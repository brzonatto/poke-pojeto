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
public class TipoPokemonCreateDTO {
    @NotNull
    @ApiModelProperty("Lista de todos os tipos de Pokémon")
    private Tipo tipo;
}
