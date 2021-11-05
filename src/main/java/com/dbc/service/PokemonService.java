package com.dbc.service;

import com.dbc.dto.PokemonCreateDTO;
import com.dbc.dto.PokemonDTO;
import com.dbc.entity.PokemonEntity;
import com.dbc.repository.PokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final ObjectMapper objectMapper;

    public PokemonDTO create(PokemonCreateDTO pokemonCreateDTO){
        PokemonEntity pokemonEntity = objectMapper.convertValue(pokemonCreateDTO, PokemonEntity.class);
        PokemonEntity pokemonCriado = pokemonRepository.create(pokemonEntity);
        return objectMapper.convertValue(pokemonCriado, PokemonDTO.class);
    }
}
