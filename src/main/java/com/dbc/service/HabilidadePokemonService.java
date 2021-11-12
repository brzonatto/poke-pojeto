package com.dbc.service;

import com.dbc.dto.HabilidadeDTO;
import com.dbc.dto.HabilidadePokemonCreateDTO;
import com.dbc.dto.HabilidadePokemonDTO;
import com.dbc.dto.PokemonDTO;
import com.dbc.entity.HabilidadeEntity;
import com.dbc.entity.HabilidadePokemonEntity;
import com.dbc.enums.Tipo;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.repository.HabilidadePokemonRepository;
import com.dbc.repository.HabilidadeRepository;
import com.dbc.repository.PokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HabilidadePokemonService {
    private final HabilidadePokemonRepository habilidadePokemonRepository;
    private final HabilidadeRepository habilidadeRepository;
    private final PokemonRepository pokemonRepository;
    private final ObjectMapper objectMapper;

    public HabilidadePokemonDTO create(Integer idPokemon, HabilidadePokemonCreateDTO habilidadePokemonCreateDTO) throws RegraDeNegocioException {
        HabilidadePokemonEntity habilidadePokemonEntity = objectMapper
                .convertValue(habilidadePokemonCreateDTO, HabilidadePokemonEntity.class);
        habilidadePokemonEntity.setPokemon(pokemonRepository.getById(idPokemon));
        List<HabilidadeEntity> habilidadeEntityList = new ArrayList<>();
        for (Integer key : habilidadePokemonCreateDTO.getIdHabilidadeDTOList()) {
            habilidadeEntityList.add(habilidadeRepository.getHabilidadeById(key));
        }
        habilidadePokemonEntity.setHabilidadeEntityList(habilidadeEntityList);
        HabilidadePokemonEntity habilidadeCriada = habilidadePokemonRepository.create(habilidadePokemonEntity);
        HabilidadePokemonDTO habilidadePokemonDTO = objectMapper.convertValue(habilidadeCriada, HabilidadePokemonDTO.class);
        habilidadePokemonDTO.setIdPokemon(idPokemon);
        List<HabilidadeDTO> habilidadeDTOList = habilidadeEntityList.stream()
                .map(habilidade -> objectMapper.convertValue(habilidade, HabilidadeDTO.class))
                .collect(Collectors.toList());
        habilidadePokemonDTO.setHabilidadeDTOList(habilidadeDTOList);
        return habilidadePokemonDTO;
    }

    public List<HabilidadePokemonDTO> list() {
        return habilidadePokemonRepository.list().stream()
                .map(habilidade -> {
                    HabilidadePokemonDTO habilidadePokemonDTO = objectMapper.convertValue(habilidade, HabilidadePokemonDTO.class);
                    habilidadePokemonDTO.setIdPokemon(habilidade.getPokemon().getIdPokemon());
                    List<HabilidadeDTO> habilidadeDTOList = habilidade.getHabilidadeEntityList().stream()
                            .map(habilidade2 -> objectMapper.convertValue(habilidade2, HabilidadeDTO.class))
                            .collect(Collectors.toList());
                    habilidadePokemonDTO.setHabilidadeDTOList(habilidadeDTOList);
                    return habilidadePokemonDTO;
                })
                .collect(Collectors.toList());
    }

    public HabilidadePokemonDTO update(Integer idHabilidade, HabilidadePokemonCreateDTO habilidadePokemonCreateDTO)
            throws RegraDeNegocioException {
        HabilidadePokemonEntity habilidadePokemonEntity = habilidadePokemonRepository.getHabilidadeById(idHabilidade);
        List<HabilidadeEntity> habilidadeEntityList = new ArrayList<>();
        for (Integer key : habilidadePokemonCreateDTO.getIdHabilidadeDTOList()) {
            habilidadeEntityList.add(habilidadeRepository.getHabilidadeById(key));
        }
        habilidadePokemonEntity.setHabilidadeEntityList(habilidadeEntityList);
        HabilidadePokemonEntity habilidadeAtualizada = habilidadePokemonRepository.update(idHabilidade, habilidadePokemonEntity);
        HabilidadePokemonDTO habilidadePokemonDTO = objectMapper.convertValue(habilidadeAtualizada, HabilidadePokemonDTO.class);
        habilidadePokemonDTO.setIdPokemon(habilidadeAtualizada.getPokemon().getIdPokemon());
        List<HabilidadeDTO> habilidadeDTOList = habilidadeEntityList.stream()
                .map(habilidade -> objectMapper.convertValue(habilidade, HabilidadeDTO.class))
                .collect(Collectors.toList());
        habilidadePokemonDTO.setHabilidadeDTOList(habilidadeDTOList);
        return habilidadePokemonDTO;
    }

    public void delete(Integer idHabilidade) throws RegraDeNegocioException {
        habilidadePokemonRepository.delete(idHabilidade);
    }

    public List<PokemonDTO> listarPorHabilidade(String habilidade){
        return habilidadePokemonRepository.listarPorHabilidade(habilidade).stream()
                .map(pokemon-> {
                    return objectMapper.convertValue(pokemon, PokemonDTO.class);
                })
                .collect(Collectors.toList());
    }
}
