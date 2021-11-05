package com.dbc.service;

import com.dbc.dto.TipoPokemonCreateDTO;
import com.dbc.dto.TipoPokemonDTO;
import com.dbc.entity.PokemonEntity;
import com.dbc.entity.TipoPokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.repository.PokemonRepository;
import com.dbc.repository.TipoPokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoPokemonService {
    private final TipoPokemonRepository tipoPokemonRepository;
    private final PokemonRepository pokemonRepository;
    private final ObjectMapper objectMapper;

    public TipoPokemonDTO create(Integer idPokemon, TipoPokemonCreateDTO tipoPokemonCreateDTO) throws RegraDeNegocioException {
        pokemonRepository.getPokemonById(idPokemon);
        TipoPokemonEntity tipoPokemonEntity = objectMapper.convertValue(tipoPokemonCreateDTO, TipoPokemonEntity.class);
        tipoPokemonEntity.setIdPokemon(idPokemon);
        TipoPokemonEntity tipoPokemonEntityCriado = tipoPokemonRepository.create(tipoPokemonEntity);
        TipoPokemonDTO tipoPokemonDTO = objectMapper.convertValue(tipoPokemonEntityCriado, TipoPokemonDTO.class);
        return tipoPokemonDTO;
    }
}
