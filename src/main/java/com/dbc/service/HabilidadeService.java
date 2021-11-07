package com.dbc.service;

import com.dbc.dto.HabilidadeCreateDTO;
import com.dbc.dto.HabilidadeDTO;
import com.dbc.dto.PokemonCreateDTO;
import com.dbc.dto.PokemonDTO;
import com.dbc.entity.HabilidadeEntity;
import com.dbc.entity.PokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.repository.HabilidadeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HabilidadeService {

    private final HabilidadeRepository habilidadeRepository;
    private final ObjectMapper objectMapper;

    public HabilidadeDTO create(HabilidadeCreateDTO habilidadeDTO){
        HabilidadeEntity habilidadeEntity = objectMapper.convertValue(habilidadeDTO, HabilidadeEntity.class);
        HabilidadeEntity habilidadeCriada = habilidadeRepository.create(habilidadeEntity);
        return objectMapper.convertValue(habilidadeCriada, HabilidadeDTO.class);
    }

    public List<HabilidadeDTO> list() {
        return habilidadeRepository.list().stream()
                .map(habilidade -> objectMapper.convertValue(habilidade, HabilidadeDTO.class))
                .collect(Collectors.toList());
    }

    public HabilidadeDTO update(Integer id, HabilidadeCreateDTO habilidadeCreateDTO) throws RegraDeNegocioException {
        HabilidadeEntity habilidadeEntity = objectMapper.convertValue(habilidadeCreateDTO, HabilidadeEntity.class);
        HabilidadeEntity habilidadeAtualizada = habilidadeRepository.update(id, habilidadeEntity);
        HabilidadeDTO habilidadeDTO = objectMapper.convertValue(habilidadeAtualizada, HabilidadeDTO.class);
        return habilidadeDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException{
        habilidadeRepository.delete(id);
    }

    public List<PokemonDTO> listarPorHabilidade(String habilidade){
        return habilidadeRepository.listarPorHabilidade(habilidade).stream()
                .map(pokemon -> {
                    return objectMapper.convertValue(pokemon, PokemonDTO.class);
                })
                .collect(Collectors.toList());
    }
}
