package com.dbc.service;

import com.dbc.dto.EvolucaoCreateDTO;
import com.dbc.dto.EvolucaoDTO;
import com.dbc.entity.EvolucaoEntity;
import com.dbc.entity.PokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.repository.EvolucaoRepository;
import com.dbc.repository.PokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EvolucaoService {
    private final EvolucaoRepository evolucaoRepository;
    private final PokemonRepository pokemonRepository;
    private final ObjectMapper objectMapper;

    public EvolucaoDTO create(EvolucaoCreateDTO evolucaoCreateDTO) throws RegraDeNegocioException {
        PokemonEntity estagioUm = pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioUm());
        PokemonEntity estagioDois = pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioDois());
        PokemonEntity estagioTres = pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioTres());
        EvolucaoEntity evolucaoEntity = objectMapper.convertValue(evolucaoCreateDTO, EvolucaoEntity.class);
        evolucaoEntity.setEstagioUm(estagioUm);
        evolucaoEntity.setEstagioDois(estagioDois);
        evolucaoEntity.setEstagioTres(estagioTres);
        evolucaoRepository.create(evolucaoEntity);
        EvolucaoDTO evolucaoDTO = objectMapper.convertValue(evolucaoEntity, EvolucaoDTO.class);
        return evolucaoDTO;
    }

    public List<EvolucaoDTO> list() {
        return evolucaoRepository.list().stream()
                .map(evolucao -> objectMapper.convertValue(evolucao, EvolucaoDTO.class))
                .collect(Collectors.toList());
    }

    public EvolucaoDTO update(Integer idEvolucao, EvolucaoCreateDTO evolucaoCreateDTO) throws RegraDeNegocioException {
        EvolucaoEntity entity = objectMapper.convertValue(evolucaoCreateDTO, EvolucaoEntity.class);
        entity.setEstagioUm(pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioUm()));
        entity.setEstagioDois(pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioDois()));
        entity.setEstagioTres(pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioTres()));
        EvolucaoEntity update = evolucaoRepository.update(idEvolucao, entity);
        EvolucaoDTO evolucaoDTO = objectMapper.convertValue(update, EvolucaoDTO.class);
        return evolucaoDTO;
    }

    public void delete(Integer idEvolucao) throws RegraDeNegocioException {
        evolucaoRepository.delete(idEvolucao);
    }
}
