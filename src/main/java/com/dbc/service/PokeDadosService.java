package com.dbc.service;

import com.dbc.dto.*;
import com.dbc.entity.PokemonEntity;
import com.dbc.entity.TipoPokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.repository.EvolucaoRepository;
import com.dbc.repository.HabilidadePokemonRepository;
import com.dbc.repository.PokemonRepository;
import com.dbc.repository.TipoPokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PokeDadosService {
    private final PokemonRepository pokemonRepository;
    private final TipoPokemonRepository tipoPokemonRepository;
    private final HabilidadePokemonRepository habilidadePokemonRepository;
    private final EvolucaoRepository evolucaoRepository;
    private final ObjectMapper objectMapper;

    public List<PokeDadosDTO> list() throws RegraDeNegocioException {
        List<PokeDadosDTO> pokeDadosDTOList = new ArrayList<>();
        Integer index = 0;
        for (PokemonEntity key : pokemonRepository.list()) {
            pokeDadosDTOList.add(new PokeDadosDTO());
            pokeDadosDTOList.get(index).setPokemon(objectMapper.convertValue(key, PokemonCreateDTO.class));
            TipoPokemonDTO tipoPokemonDTO = objectMapper.convertValue(tipoPokemonRepository.getTipoByPokemon(key.getIdPokemon()), TipoPokemonDTO.class);
            tipoPokemonDTO.setIdPokemon(key.getIdPokemon());
            pokeDadosDTOList.get(index).setTipo(objectMapper.convertValue(tipoPokemonDTO, TipoPokemonCreateDTO.class));
//            pokeDadosDTOList.get(index).setHabilidade(objectMapper.convertValue(habilidadePokemonRepository.getHabilidadeByPokemon(key.getIdPokemon()), HabilidadePokemonDTO.class));
            EvolucaoDTO evolucaoDTO = objectMapper.convertValue(evolucaoRepository.getEvolucaoByPokemon(key.getIdPokemon()), EvolucaoDTO.class);
            EvolucaoNomesDTO evolucaoNomesDTO = new EvolucaoNomesDTO();
            evolucaoNomesDTO.setEstagioUm(evolucaoDTO.getEstagioUm().getNome());
            evolucaoNomesDTO.setEstagioDois(evolucaoDTO.getEstagioDois().getNome());
            evolucaoNomesDTO.setEstagioTres(evolucaoDTO.getEstagioTres().getNome());
            pokeDadosDTOList.get(index).setEvolucao(evolucaoNomesDTO);
            index++;
        }
        return pokeDadosDTOList;
    }

}
