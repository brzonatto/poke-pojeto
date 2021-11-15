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
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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


    public TipoPokemonDTO create(Integer idPokemon, Tipo tipo) throws RegraDeNegocioException {
        PokemonEntity entity = pokemonRepository.findById(idPokemon).orElseThrow(() -> new RegraDeNegocioException("NAO ACHOU O POKE"));
        if (existPoke(idPokemon)) {
            throw new RegraDeNegocioException("pokémon deve ser diferente, pois, já existe tipo cadastrado");
        }
        if (existeTipoRepetido(entity, tipo)) {
            throw new RegraDeNegocioException("não deve conter tipos repetidos");
        }
//        TipoPokemonEntity tipoPokemonEntity = objectMapper.convertValue(tipoPokemonCreateDTO, TipoPokemonEntity.class);
        TipoPokemonEntity tipoPokemonEntity = new TipoPokemonEntity();
        tipoPokemonEntity.setPokemon(entity);
        tipoPokemonEntity.setTipo(tipo);
        TipoPokemonEntity tipoPokemonEntityCriado = tipoPokemonRepository.save(tipoPokemonEntity);
        TipoPokemonDTO tipoPokemonDTO = objectMapper.convertValue(tipoPokemonEntityCriado, TipoPokemonDTO.class);
        tipoPokemonDTO.setIdPokemon(idPokemon);
        return tipoPokemonDTO;
    }

    public boolean existeTipoRepetido(PokemonEntity entity, Tipo tipo) {
        List<TipoPokemonEntity> tipos = tipoPokemonRepository.findAll();
        return tipos.contains(tipo);
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
        TipoPokemonEntity tipoPokemonEntity = findById(idTipo);
        TipoPokemonEntity entity = objectMapper.convertValue(tipoPokemonCreateDTO, TipoPokemonEntity.class);
        entity.setIdTipoPokemon(idTipo);
        entity.setPokemon(tipoPokemonEntity.getPokemon());
        TipoPokemonEntity update = tipoPokemonRepository.save(entity);
        TipoPokemonDTO tipoPokemonDTO = objectMapper.convertValue(update, TipoPokemonDTO.class);
        tipoPokemonDTO.setIdPokemon(tipoPokemonEntity.getPokemon().getIdPokemon());
        return tipoPokemonDTO;
    }

    public void delete(Integer idTipo) throws RegraDeNegocioException {
        TipoPokemonEntity tipoPokemonEntity = findById(idTipo);
        tipoPokemonRepository.delete(tipoPokemonEntity);
    }






//    public Boolean existTipoRepetido(List<Tipo> tipoList) {
//        List<Tipo> semRepetidos = tipoList.stream().distinct().collect(Collectors.toList());
//        if (semRepetidos.size() != tipoList.size()) {
//            return true;
//        }
//        return false;
//    }
}
