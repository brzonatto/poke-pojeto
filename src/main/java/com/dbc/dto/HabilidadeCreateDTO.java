package com.dbc.dto;

import com.dbc.entity.PokemonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadeCreateDTO {
    private String nome;
    private Double multiplicacaoDePoder;
}
