package com.dbc.dto;

import com.dbc.entity.PokemonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvolucaoDTO {
    private Integer idEvolucao;
    private PokemonEntity estagioUm;
    private PokemonEntity estagioDois;
    private PokemonEntity estagioTres;
}
