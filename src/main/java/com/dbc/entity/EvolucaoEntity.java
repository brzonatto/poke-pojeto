package com.dbc.entity;

import javax.validation.constraints.NotNull;

public class EvolucaoEntity {

    @NotNull
    private Integer idEvolucao;
    private PokemonEntity estagioUm;
    private PokemonEntity estagioDois;
    private PokemonEntity estagioTres; 
}
