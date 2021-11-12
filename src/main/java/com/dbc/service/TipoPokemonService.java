package com.dbc.service;

import com.dbc.dto.PokemonDTO;
import com.dbc.dto.TipoPokemonCreateDTO;
import com.dbc.dto.TipoPokemonDTO;
import com.dbc.entity.PokemonEntity;
import com.dbc.entity.TipoPokemonEntity;
import com.dbc.enums.Tipo;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.repository.PokemonRepository;
import com.dbc.repository.TipoPokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TipoPokemonService {
    private final TipoPokemonRepository tipoPokemonRepository;
    private final PokemonRepository pokemonRepository;
    private final ObjectMapper objectMapper;

    private TipoPokemonEntity findById(Integer id) throws RegraDeNegocioException {
        TipoPokemonEntity entity = tipoPokemonRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Tipo não encontrado"));
        return entity;
    }

    public Boolean existPoke(Integer idPokemon) {
        return pokemonRepository.existsById(idPokemon);
    }


    public TipoPokemonDTO create(Integer idPokemon, TipoPokemonCreateDTO tipoPokemonCreateDTO) throws RegraDeNegocioException {
        if (existPoke(idPokemon)) {
            throw new RegraDeNegocioException("pokémon deve ser diferente, pois, já existe tipo cadastrado");
        }
        if (existTipoRepetido(tipoPokemonCreateDTO.getTipo())) {
            throw new RegraDeNegocioException("não deve conter tipos repetidos");
        }
        PokemonEntity entity = pokemonRepository.findById(idPokemon).orElseThrow(() -> new RegraDeNegocioException(""));
        TipoPokemonEntity tipoPokemonEntity = objectMapper.convertValue(tipoPokemonCreateDTO, TipoPokemonEntity.class);
        tipoPokemonEntity.setPokemon(entity);
        TipoPokemonEntity tipoPokemonEntityCriado = tipoPokemonRepository.save(tipoPokemonEntity);
        TipoPokemonDTO tipoPokemonDTO = objectMapper.convertValue(tipoPokemonEntityCriado, TipoPokemonDTO.class);
        tipoPokemonDTO.setIdPokemon(idPokemon);
        return tipoPokemonDTO;
    }

    public List<TipoPokemonDTO> list() {
        return tipoPokemonRepository.findAll().stream()
                .map(tipo -> {
                    TipoPokemonDTO tipoPokemonDTO = objectMapper.convertValue(tipo, TipoPokemonDTO.class);
                    tipoPokemonDTO.setIdPokemon(tipo.getPokemon().getIdPokemon());
                    return tipoPokemonDTO;
                })
                .collect(Collectors.toList());
    }

    public TipoPokemonDTO update(Integer idTipo, TipoPokemonCreateDTO tipoPokemonCreateDTO) throws RegraDeNegocioException {
        findById(idTipo);
        TipoPokemonEntity entity = objectMapper.convertValue(tipoPokemonCreateDTO, TipoPokemonEntity.class);
        entity.setIdTipoPokemon(idTipo);
        TipoPokemonEntity update = tipoPokemonRepository.save(entity);
        TipoPokemonDTO tipoPokemonDTO = objectMapper.convertValue(update, TipoPokemonDTO.class);
        return tipoPokemonDTO;
    }

    public void delete(Integer idTipo) throws RegraDeNegocioException {
        TipoPokemonEntity tipoPokemonEntity = findById(idTipo);
        tipoPokemonRepository.delete(tipoPokemonEntity);
    }



    public Boolean existTipoRepetido(List<Tipo> tipoList) {
        List<Tipo> semRepetidos = tipoList.stream().distinct().collect(Collectors.toList());
        if (semRepetidos.size() != tipoList.size()) {
            return true;
        }
        return false;
    }

//    public List<PokemonDTO> listarPorTipo(String tipo){
//        return tipoPokemonRepository.listarPorTipo(tipo).stream()
//                .map(pokemon-> {
//                    return objectMapper.convertValue(pokemon, PokemonDTO.class);
//                })
//                .collect(Collectors.toList());
//    }
}
