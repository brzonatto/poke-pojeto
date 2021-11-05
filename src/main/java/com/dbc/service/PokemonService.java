package com.dbc.service;

import com.dbc.dto.PokemonCreateDTO;
import com.dbc.dto.PokemonDTO;
import com.dbc.entity.PokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.repository.PokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PokemonDTO> list() {
        return pokemonRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PokemonDTO.class))
                .collect(Collectors.toList());
    }

    public PokemonDTO update(Integer id, PokemonCreateDTO pokemonCreateDTO) throws RegraDeNegocioException {
        PokemonEntity pokemonEntity = objectMapper.convertValue(pokemonCreateDTO, PokemonEntity.class);
        PokemonEntity pokemonAtualizado = pokemonRepository.update(id, pokemonEntity);
        PokemonDTO pokemonDTO = objectMapper.convertValue(pokemonAtualizado, PokemonDTO.class);
        return objectMapper.convertValue(pokemonAtualizado, PokemonDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException{
        pokemonRepository.delete(id);
    }
}
