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
        if (evolucaoRepository.existEvolucaoByPokemon(evolucaoCreateDTO.getIdEstagioUm())
                || evolucaoRepository.existEvolucaoByPokemon(evolucaoCreateDTO.getIdEstagioDois())
                || evolucaoRepository.existEvolucaoByPokemon(evolucaoCreateDTO.getIdEstagioTres())) {
            throw new RegraDeNegocioException("Pokémon deve ser diferente, pois, já existe em uma evolução cadastrada");
        }
        if (evolucaoCreateDTO.getIdEstagioUm() == evolucaoCreateDTO.getIdEstagioDois()
                || evolucaoCreateDTO.getIdEstagioDois() == evolucaoCreateDTO.getIdEstagioTres()
                || evolucaoCreateDTO.getIdEstagioTres() == evolucaoCreateDTO.getIdEstagioUm()) {
            throw new RegraDeNegocioException("não deve conter Pokémons repetidos dentro de uma evolução");
        }
        PokemonEntity estagioUm = pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioUm());
        PokemonEntity estagioDois = pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioDois());
        EvolucaoEntity evolucaoEntity = objectMapper.convertValue(evolucaoCreateDTO, EvolucaoEntity.class);
        evolucaoEntity.setEstagioUm(estagioUm);
        evolucaoEntity.setEstagioDois(estagioDois);
        if (evolucaoCreateDTO.getIdEstagioTres() != null) {
            PokemonEntity estagioTres = pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioTres());
            evolucaoEntity.setEstagioTres(estagioTres);
        }
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

        EvolucaoEntity evolucaoBackup = evolucaoRepository.getEvolucaoById(idEvolucao);
        EvolucaoEntity oi = new EvolucaoEntity();
        oi.setIdEvolucao(evolucaoBackup.getIdEvolucao());
        oi.setEstagioUm(evolucaoBackup.getEstagioUm());
        oi.setEstagioDois(evolucaoBackup.getEstagioDois());
        oi.setEstagioTres(evolucaoBackup.getEstagioTres());
        updateToNull(idEvolucao);
        if (evolucaoRepository.existEvolucaoByPokemon(evolucaoCreateDTO.getIdEstagioUm())
                || evolucaoRepository.existEvolucaoByPokemon(evolucaoCreateDTO.getIdEstagioDois())
                || evolucaoRepository.existEvolucaoByPokemon(evolucaoCreateDTO.getIdEstagioTres())) {
            evolucaoRepository.update(idEvolucao, oi);
            throw new RegraDeNegocioException("Pokémon deve ser diferente, pois, já existe em uma evolução cadastrada");
        }
        if (evolucaoCreateDTO.getIdEstagioUm() == evolucaoCreateDTO.getIdEstagioDois()
                || evolucaoCreateDTO.getIdEstagioDois() == evolucaoCreateDTO.getIdEstagioTres()
                || evolucaoCreateDTO.getIdEstagioTres() == evolucaoCreateDTO.getIdEstagioUm()) {
            evolucaoRepository.update(idEvolucao, oi);
            throw new RegraDeNegocioException("não deve conter Pokémons repetidos dentro de uma evolução");
        }
        EvolucaoEntity entity = objectMapper.convertValue(evolucaoCreateDTO, EvolucaoEntity.class);
        entity.setEstagioUm(pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioUm()));
        entity.setEstagioDois(pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioDois()));
        if (evolucaoCreateDTO.getIdEstagioTres() != null) {
            entity.setEstagioTres(pokemonRepository.getPokemonById(evolucaoCreateDTO.getIdEstagioTres()));
        }
        EvolucaoEntity update = evolucaoRepository.update(idEvolucao, entity);
        EvolucaoDTO evolucaoDTO = objectMapper.convertValue(update, EvolucaoDTO.class);
        return evolucaoDTO;
    }

    public void delete(Integer idEvolucao) throws RegraDeNegocioException {
        evolucaoRepository.delete(idEvolucao);
    }

    public void updateToNull(Integer idEvolucao) throws RegraDeNegocioException {
        EvolucaoEntity evolucaoEntity = evolucaoRepository.getEvolucaoById(idEvolucao);
        evolucaoEntity.setEstagioUm(null);
        evolucaoEntity.setEstagioDois(null);
        evolucaoEntity.setEstagioTres(null);
        evolucaoRepository.update(idEvolucao, evolucaoEntity);
    }


}
