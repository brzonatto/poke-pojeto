package com.dbc.service;

import com.dbc.dto.PokemonCreateDTO;
import com.dbc.dto.PokemonDTO;
import com.dbc.entity.PokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.repository.EvolucaoRepository;
import com.dbc.repository.HabilidadePokemonRepository;
import com.dbc.repository.PokemonRepository;
import com.dbc.repository.TipoPokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final TipoPokemonRepository tipoPokemonRepository;
    private final EvolucaoRepository evolucaoRepository;
    private final HabilidadePokemonRepository habilidadePokemonRepository;
    private final ObjectMapper objectMapper;

    public PokemonDTO create(PokemonCreateDTO pokemonCreateDTO) throws RegraDeNegocioException {
        if (somaStatus(pokemonCreateDTO) >= 580 && pokemonCreateDTO.getRegiaoDominante() == null) {
            throw new RegraDeNegocioException("deve conter região dominate, pois o pokémon é lendário");
        }
        PokemonEntity pokemonEntity = objectMapper.convertValue(pokemonCreateDTO, PokemonEntity.class);
        PokemonEntity pokemonCriado = pokemonRepository.save(pokemonEntity);
        PokemonDTO pokemonDTO = objectMapper.convertValue(pokemonCriado, PokemonDTO.class);
        return pokemonDTO;
    }

    public List<PokemonDTO> list() {
        return pokemonRepository.findAll().stream()
                .map(pokemon -> objectMapper.convertValue(pokemon, PokemonDTO.class))
                .collect(Collectors.toList());
    }

    public PokemonDTO update(Integer idPokemon, PokemonCreateDTO pokemonCreateDTO) throws RegraDeNegocioException {
        if (somaStatus(pokemonCreateDTO) >= 580 && pokemonCreateDTO.getRegiaoDominante() == null) {
            throw new RegraDeNegocioException("deve conter região dominate, pois o pokémon é lendário");
        }
        pokemonRepository.findById(idPokemon).orElseThrow(() -> new RegraDeNegocioException("Pokémon não encontrado"));
        PokemonEntity pokemonEntity = objectMapper.convertValue(pokemonCreateDTO, PokemonEntity.class);
        pokemonEntity.setIdPokemon(idPokemon);
        PokemonEntity pokemonAtualizado = pokemonRepository.save(pokemonEntity);
        PokemonDTO pokemonDTO = objectMapper.convertValue(pokemonAtualizado, PokemonDTO.class);
        return pokemonDTO;
    }

    public void delete(Integer idPokemon) throws RegraDeNegocioException {
        PokemonEntity entity = pokemonRepository.getById(idPokemon);
//        if (tipoPokemonRepository.existTipoByPokemon(idPokemon)) {
//            tipoPokemonRepository.delete(tipoPokemonRepository.getTipoByPokemon(idPokemon).getIdTipoPokemon());
//        }
//        if (evolucaoRepository.existEvolucaoByPokemon(idPokemon)) {
//            evolucaoRepository.delete(evolucaoRepository.getEvolucaoByPokemon(idPokemon).getIdEvolucao());
//        }
//        if (habilidadePokemonRepository.existHabilidadeByPokemon(idPokemon)) {
//            habilidadePokemonRepository.delete(habilidadePokemonRepository.getHabilidadeByPokemon(idPokemon).getIdHabilidadePokemon());
//        }
        pokemonRepository.delete(entity);
    }

    public Integer somaStatus(PokemonCreateDTO pokemonCreateDTO) {
        return pokemonCreateDTO.getStatus().getAtaque() + pokemonCreateDTO.getStatus().getHp()
                + pokemonCreateDTO.getStatus().getDefesa() + pokemonCreateDTO.getStatus().getEspecialAtaque()
                + pokemonCreateDTO.getStatus().getEspecialDefesa() + pokemonCreateDTO.getStatus().getVelocidade();
    }
}
