package com.dbc.repository;

import com.dbc.entity.TipoPokemonEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TipoPokemonRepository {
    private static List<TipoPokemonEntity> tipoPokemonEntityList = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public TipoPokemonEntity create(Integer idPokemon, TipoPokemonEntity tipoPokemonEntity) {
        tipoPokemonEntity.setIdTipoPokemon(COUNTER.incrementAndGet());
        tipoPokemonEntityList.add(tipoPokemonEntity);
        return tipoPokemonEntity;
    }
}
