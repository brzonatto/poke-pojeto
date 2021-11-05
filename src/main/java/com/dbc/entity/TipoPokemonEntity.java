package com.dbc.entity;

import com.dbc.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPokemonEntity {


    private Integer idTipoPokemon;
    private Tipo tipo;
    private PokemonEntity pokemon;
}
