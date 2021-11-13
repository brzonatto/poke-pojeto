package com.dbc.service;

import com.dbc.dto.*;
import com.dbc.entity.EvolucaoEntity;
import com.dbc.entity.HabilidadeEntity;
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

    private EvolucaoEntity findById(Integer id) throws RegraDeNegocioException {
        EvolucaoEntity entity = evolucaoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Não encontrado"));
        return entity;
    }

    public EvolucaoDTO create(EvolucaoCreateDTO evolucaoCreateDTO) {
        EvolucaoEntity evolucaoEntity = new EvolucaoEntity();
        evolucaoEntity.setEstagioUm(pokemonRepository.findById(evolucaoCreateDTO.getIdEstagioUm()).get());
        evolucaoEntity.setEstagioDois(pokemonRepository.findById(evolucaoCreateDTO.getIdEstagioUm()).get());
        if (evolucaoCreateDTO.getIdEstagioTres() != null) {
            evolucaoEntity.setEstagioTres(pokemonRepository.findById(evolucaoCreateDTO.getIdEstagioUm()).get());
        }
        evolucaoEntity = evolucaoRepository.save(evolucaoEntity);
        EvolucaoDTO evolucaoDTO = new EvolucaoDTO();
        evolucaoDTO.setIdEvolucao(evolucaoEntity.getIdEvolucao());
        evolucaoDTO.setEstagioUm(objectMapper.convertValue(evolucaoEntity.getEstagioUm(), PokemonDTO.class));
        evolucaoDTO.setEstagioDois(objectMapper.convertValue(evolucaoEntity.getEstagioDois(), PokemonDTO.class));
        evolucaoDTO.setEstagioTres(objectMapper.convertValue(evolucaoEntity.getEstagioTres(), PokemonDTO.class));
        return evolucaoDTO;
    }

    public List<EvolucaoDTO> list() {
        return evolucaoRepository.findAll().stream()
                .map(evolucao -> objectMapper.convertValue(evolucao, EvolucaoDTO.class))
                .collect(Collectors.toList());
    }

    public EvolucaoDTO update(Integer idEvolucao, EvolucaoCreateDTO evolucaoCreateDTO) throws RegraDeNegocioException {
//        EvolucaoEntity evolucaoBackup = findById(idEvolucao);
//        EvolucaoEntity oi = new EvolucaoEntity();
//        oi.setIdEvolucao(evolucaoBackup.getIdEvolucao());
//        oi.setEstagioUm(evolucaoBackup.getEstagioUm());
//        oi.setEstagioDois(evolucaoBackup.getEstagioDois());
//        oi.setEstagioTres(evolucaoBackup.getEstagioTres());
//        updateToNull(idEvolucao);
//        if (evolucaoRepository.existEvolucaoByPokemon(evolucaoCreateDTO.getIdEstagioUm())
//                || evolucaoRepository.existEvolucaoByPokemon(evolucaoCreateDTO.getIdEstagioDois())
//                || evolucaoRepository.existEvolucaoByPokemon(evolucaoCreateDTO.getIdEstagioTres())) {
//            evolucaoRepository.update(idEvolucao, oi);
//            throw new RegraDeNegocioException("Pokémon deve ser diferente, pois, já existe em uma evolução cadastrada");
//        }
//        if (evolucaoCreateDTO.getIdEstagioUm() == evolucaoCreateDTO.getIdEstagioDois()
//                || evolucaoCreateDTO.getIdEstagioDois() == evolucaoCreateDTO.getIdEstagioTres()
//                || evolucaoCreateDTO.getIdEstagioTres() == evolucaoCreateDTO.getIdEstagioUm()) {
//            evolucaoRepository.update(idEvolucao, oi);
//            throw new RegraDeNegocioException("não deve conter Pokémons repetidos dentro de uma evolução");
//        }
        findById(idEvolucao);
        EvolucaoEntity entity = objectMapper.convertValue(evolucaoCreateDTO, EvolucaoEntity.class);
        entity.setIdEvolucao(idEvolucao);
        entity.setEstagioUm(pokemonRepository.getById(evolucaoCreateDTO.getIdEstagioUm()));
        entity.setEstagioDois(pokemonRepository.getById(evolucaoCreateDTO.getIdEstagioDois()));
        if (evolucaoCreateDTO.getIdEstagioTres() != null) {
            entity.setEstagioTres(pokemonRepository.getById(evolucaoCreateDTO.getIdEstagioTres()));
        }
        EvolucaoEntity update = evolucaoRepository.save(entity);
        return objectMapper.convertValue(update, EvolucaoDTO.class);
    }

//    public HabilidadeDTO update(Integer idHabilidade, HabilidadeCreateDTO habilidadeCreateDTO) throws RegraDeNegocioException {
//        findById(idHabilidade);
//        HabilidadeEntity entity = objectMapper.convertValue(habilidadeCreateDTO, HabilidadeEntity.class);
//        entity.setIdHabilidade(idHabilidade);
//        HabilidadeEntity update = habilidadeRepository.save(entity);
//        HabilidadeDTO habilidadeDTO = objectMapper.convertValue(update, HabilidadeDTO.class);
//        return habilidadeDTO;
//    }


    public void delete(Integer idEvolucao) throws RegraDeNegocioException {
        EvolucaoEntity entity = findById(idEvolucao);
        evolucaoRepository.delete(entity);
    }

//
//    public void updateToNull(Integer idEvolucao) throws RegraDeNegocioException {
//        EvolucaoEntity evolucaoEntity = evolucaoRepository.getEvolucaoById(idEvolucao);
//        evolucaoEntity.setEstagioUm(null);
//        evolucaoEntity.setEstagioDois(null);
//        evolucaoEntity.setEstagioTres(null);
//        evolucaoRepository.update(idEvolucao, evolucaoEntity);
//    }
}
