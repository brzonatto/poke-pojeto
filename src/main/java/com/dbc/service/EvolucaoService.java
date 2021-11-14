package com.dbc.service;

import com.dbc.dto.*;
import com.dbc.entity.EvolucaoEntity;
import com.dbc.entity.HabilidadeEntity;
import com.dbc.entity.PokemonEntity;
import com.dbc.entity.TipoPokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.repository.EvolucaoRepository;
import com.dbc.repository.PokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public EvolucaoDTO create(EvolucaoCreateDTO evolucaoCreateDTO) { //TODO arrumar regra de negocio
        PokemonEntity estagioUm = pokemonRepository.findById(evolucaoCreateDTO.getIdEstagioUm()).get();
        PokemonEntity estagioDois = pokemonRepository.findById(evolucaoCreateDTO.getIdEstagioDois()).get();
        PokemonEntity estagioTres = null;

        EvolucaoEntity evolucaoEntity = objectMapper.convertValue(evolucaoCreateDTO, EvolucaoEntity.class);
        evolucaoEntity.setEstagioUm(estagioUm);
        evolucaoEntity.setEstagioDois(estagioDois);
        if (evolucaoCreateDTO.getIdEstagioTres() != null) {
            estagioTres = pokemonRepository.findById(evolucaoCreateDTO.getIdEstagioTres()).get();
            evolucaoEntity.setEstagioTres(estagioTres);
        }

        EvolucaoEntity evolucaoCriada = evolucaoRepository.save(evolucaoEntity);

        estagioUm.setEvolucaoEntity(evolucaoCriada);
        estagioDois.setEvolucaoEntity(evolucaoCriada);
        if (evolucaoCreateDTO.getIdEstagioTres() != null) {
            estagioTres.setEvolucaoEntity(evolucaoCriada);
        }

        PokemonEntity updateEstagioUm = pokemonRepository.save(estagioUm);
        PokemonEntity updateEstagioDois = pokemonRepository.save(estagioDois);
        PokemonEntity updateEstagiotres = null;
        if (evolucaoCreateDTO.getIdEstagioTres() != null) {
            updateEstagiotres = pokemonRepository.save(estagioTres);
        }

        EvolucaoDTO evolucaoDTO = objectMapper.convertValue(evolucaoCriada, EvolucaoDTO.class);
        evolucaoDTO.setEstagioUm(objectMapper.convertValue(updateEstagioUm, PokemonDTO.class));
        evolucaoDTO.setEstagioDois(objectMapper.convertValue(updateEstagioDois, PokemonDTO.class));
        evolucaoDTO.setEstagioTres(objectMapper.convertValue(updateEstagiotres, PokemonDTO.class));
        return evolucaoDTO;
    }

    public List<EvolucaoDTO> list() { //TODO setar pokemons
        return evolucaoRepository.findAll().stream()
                .map(evolucao -> objectMapper.convertValue(evolucao, EvolucaoDTO.class))
                .collect(Collectors.toList());
    }

    public EvolucaoDTO update(Integer idEvolucao, EvolucaoCreateDTO evolucaoCreateDTO) throws RegraDeNegocioException { //TODO arrumar regra de negocio
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

        EvolucaoEntity evolucaoEntity = findById(idEvolucao);
        EvolucaoEntity entity = objectMapper.convertValue(evolucaoCreateDTO, EvolucaoEntity.class);
        entity.setIdEvolucao(idEvolucao);

        entity.setEstagioUm(pokemonRepository.getById(evolucaoCreateDTO.getIdEstagioUm()));
        entity.setEstagioDois(pokemonRepository.getById(evolucaoCreateDTO.getIdEstagioDois()));
        if (evolucaoCreateDTO.getIdEstagioTres() != null) {
            entity.setEstagioTres(pokemonRepository.getById(evolucaoCreateDTO.getIdEstagioTres()));
        }
        EvolucaoEntity update = evolucaoRepository.save(entity);
        EvolucaoDTO evolucaoDTO = objectMapper.convertValue(update, EvolucaoDTO.class);
        evolucaoDTO.setIdEvolucao(evolucaoEntity.getIdEvolucao());
        return evolucaoDTO;
    }

//    public TipoPokemonDTO update(Integer idTipo, TipoPokemonCreateDTO tipoPokemonCreateDTO) throws RegraDeNegocioException {
//        TipoPokemonEntity tipoPokemonEntity = findById(idTipo);
//        TipoPokemonEntity entity = objectMapper.convertValue(tipoPokemonCreateDTO, TipoPokemonEntity.class);
//        entity.setIdTipoPokemon(idTipo);
//        entity.setPokemon(tipoPokemonEntity.getPokemon());
//        TipoPokemonEntity update = tipoPokemonRepository.save(entity);
//        TipoPokemonDTO tipoPokemonDTO = objectMapper.convertValue(update, TipoPokemonDTO.class);
//        tipoPokemonDTO.setIdPokemon(tipoPokemonEntity.getPokemon().getIdPokemon());
//        return tipoPokemonDTO;
//    }


    public void delete(Integer idEvolucao) throws RegraDeNegocioException {
        EvolucaoEntity entity = findById(idEvolucao);
        PokemonEntity updateUm = pokemonRepository.findById(entity.getEstagioUm().getIdPokemon()).get();
        updateUm.setEvolucaoEntity(null);
        PokemonEntity updateDois = pokemonRepository.findById(entity.getEstagioDois().getIdPokemon()).get();
        updateDois.setEvolucaoEntity(null);
        PokemonEntity updateTres = pokemonRepository.findById(entity.getEstagioTres().getIdPokemon()).get();
        updateTres.setEvolucaoEntity(null);

        List<PokemonEntity> list = new ArrayList<>();
        list.add(updateUm);
        list.add(updateDois);
        list.add(updateTres);

        pokemonRepository.saveAll(list);
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
