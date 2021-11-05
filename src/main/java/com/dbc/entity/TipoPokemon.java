package com.dbc.entity;

import com.dbc.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPokemon {
    private Integer idTipoPokemon;
    private Tipo tipo;
    private PokemonEntity pokemon;
}
