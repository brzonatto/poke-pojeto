package com.dbc.service;

import com.dbc.repository.EvolucaoRepository;
import com.dbc.repository.HabilidadePokemonRepository;
import com.dbc.repository.PokemonRepository;
import com.dbc.repository.TipoPokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokeDadosService {
    private final PokemonRepository pokemonRepository;
    private final TipoPokemonRepository tipoPokemonRepository;
    private final HabilidadePokemonRepository habilidadePokemonRepository;
    private final EvolucaoRepository evolucaoRepository;

}
