package com.dbc.service;

import com.dbc.dto.HabilidadeCreateDTO;
import com.dbc.dto.HabilidadeDTO;
import com.dbc.dto.HabilidadePokemonCreateDTO;
import com.dbc.dto.HabilidadePokemonDTO;
import com.dbc.entity.HabilidadeEntity;
import com.dbc.entity.HabilidadePokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.repository.HabilidadePokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HabilidadePokemonService {

    private final HabilidadePokemonRepository habilidadePokemonRepository;
    private final ObjectMapper objectMapper;

    public HabilidadePokemonDTO create(HabilidadePokemonCreateDTO habilidadePokemonCreateDTO){
        HabilidadePokemonEntity habilidadePokemonEntity = objectMapper
                .convertValue(habilidadePokemonCreateDTO, HabilidadePokemonEntity.class);
        HabilidadePokemonEntity habilidadeCriada = habilidadePokemonRepository.create(habilidadePokemonEntity);
        return objectMapper.convertValue(habilidadeCriada, HabilidadePokemonDTO.class);
    }

    public List<HabilidadePokemonDTO> list() {
        return habilidadePokemonRepository.list().stream()
                .map(habilidade -> objectMapper.convertValue(habilidade, HabilidadePokemonDTO.class))
                .collect(Collectors.toList());
    }

    public HabilidadePokemonDTO update(Integer idHabilidade, HabilidadePokemonCreateDTO habilidadePokemonCreateDTO)
            throws RegraDeNegocioException {
        HabilidadePokemonEntity habilidadePokemonEntity = objectMapper.convertValue(habilidadePokemonCreateDTO, HabilidadePokemonEntity.class);
        HabilidadePokemonEntity habilidadeAtualizada = habilidadePokemonRepository.update(idHabilidade, habilidadePokemonEntity);
        return objectMapper.convertValue(habilidadeAtualizada, HabilidadePokemonDTO.class);
    }

    public void delete(Integer idHabilidade) throws RegraDeNegocioException{
        habilidadePokemonRepository.delete(idHabilidade);
    }
}
