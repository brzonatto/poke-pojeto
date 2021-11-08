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
public class TipoPokemonCreateDTO {

    @ApiModelProperty("Lista de todos os tipos de Pokémon")
    private List<Tipo> tipo;
}
