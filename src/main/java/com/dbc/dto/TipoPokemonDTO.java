package com.dbc.dto;


import com.dbc.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPokemonDTO {
    private Integer idTipoPokemon;
    private Integer idPokemon;
    private List<Tipo> tipo;
}
