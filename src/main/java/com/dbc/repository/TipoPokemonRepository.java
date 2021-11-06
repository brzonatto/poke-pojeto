package com.dbc.repository;

import com.dbc.entity.PokemonEntity;
import com.dbc.entity.TipoPokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TipoPokemonRepository {
    private static List<TipoPokemonEntity> tipoPokemonEntityList = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public TipoPokemonEntity create(TipoPokemonEntity tipoPokemonEntity) {
        tipoPokemonEntity.setIdTipoPokemon(COUNTER.incrementAndGet());
        tipoPokemonEntityList.add(tipoPokemonEntity);
        return tipoPokemonEntity;
    }

    public List<TipoPokemonEntity> list() {
        return tipoPokemonEntityList;
    }

    public TipoPokemonEntity update(Integer idTipo, TipoPokemonEntity tipoPokemonEntity) throws RegraDeNegocioException {
        TipoPokemonEntity tipoPokemonEntityRecuperado = tipoPokemonEntityList.stream()
                .filter(tipo -> tipo.getIdTipoPokemon().equals(idTipo))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("tipo não encontrado"));
        tipoPokemonEntityRecuperado.setTipo(tipoPokemonEntity.getTipo());
        return tipoPokemonEntityRecuperado;
    }

    public void delete(Integer idTipo) throws RegraDeNegocioException {
        TipoPokemonEntity tipoPokemonEntity = tipoPokemonEntityList.stream()
                .filter(tipo -> tipo.getIdTipoPokemon().equals(idTipo))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Tipo não encontrado"));
        tipoPokemonEntityList.remove(tipoPokemonEntity);
    }

    public TipoPokemonEntity getTipoByPokemon(Integer idPokemon) throws RegraDeNegocioException {
        return tipoPokemonEntityList.stream()
                .filter(tipo -> tipo.getPokemon().getIdPokemon().equals(idPokemon))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pokémon não encontrado"));
    }
}
