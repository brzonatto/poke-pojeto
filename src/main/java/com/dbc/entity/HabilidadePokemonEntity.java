package com.dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadePokemonEntity {
    private Integer idHabilidadePokemon;
    private PokemonEntity pokemon;
    private List<HabilidadeEntity> habilidadeEntityList;
}
