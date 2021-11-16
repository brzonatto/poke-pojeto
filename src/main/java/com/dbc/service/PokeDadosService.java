package com.dbc.service;

import com.dbc.dto.*;
import com.dbc.entity.PokemonEntity;
import com.dbc.repository.EvolucaoRepository;
import com.dbc.repository.HabilidadeRepository;
import com.dbc.repository.PokemonRepository;
import com.dbc.repository.TipoPokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PokeDadosService {
    private final PokemonRepository pokemonRepository;
    private final TipoPokemonRepository tipoPokemonRepository;
    private final HabilidadeRepository habilidadeRepository;
    private final EvolucaoRepository evolucaoRepository;
    private final ObjectMapper objectMapper;

    public List<PokeDadosDTO> list() {
        return pokemonRepository.findAll()
                .stream()
                .map(pokemon -> {
                    PokemonCreateDTO pokemonCreateDTO = objectMapper.convertValue(pokemon, PokemonCreateDTO.class);
                    PokeDadosDTO pokeDadosDTO = new PokeDadosDTO();
                    pokeDadosDTO.setPokemon(pokemonCreateDTO);
                    pokeDadosDTO.setTipos(
                            pokemon.getTipos()
                                    .stream()
                                    .map(tipo -> objectMapper.convertValue(tipo, TipoPokemonCreateDTO.class))
                                    .collect(Collectors.toList())
                    );
                    pokeDadosDTO.setHabilidades(
                            pokemon.getHabilidades()
                                    .stream()
                                    .map(habilidade -> objectMapper.convertValue(habilidade, HabilidadeCreateDTO.class))
                                    .collect(Collectors.toList())
                    );
                    EvolucaoNomesDTO evolucaoNomesDTO = new EvolucaoNomesDTO();
                    evolucaoNomesDTO.setEstagioUm(pokemon.getEvolucaoEntity().getEstagioUm().getNome());
                    evolucaoNomesDTO.setEstagioDois(pokemon.getEvolucaoEntity().getEstagioDois().getNome());
                    if (pokemon.getEvolucaoEntity().getEstagioTres() != null) {
                        evolucaoNomesDTO.setEstagioTres(pokemon.getEvolucaoEntity().getEstagioTres().getNome());
                    }
                    pokeDadosDTO.setEvolucao(evolucaoNomesDTO);
                    return pokeDadosDTO;
                })
                .collect(Collectors.toList());
    }
}
