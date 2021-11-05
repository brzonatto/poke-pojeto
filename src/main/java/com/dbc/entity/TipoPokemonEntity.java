package com.dbc.entity;

import com.dbc.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPokemonEntity {
    private Integer idTipoPokemon;
    private Integer idPokemon;
    private List<Tipo> tipo;
}
