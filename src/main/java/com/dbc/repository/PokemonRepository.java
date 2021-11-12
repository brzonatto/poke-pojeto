package com.dbc.repository;

import com.dbc.entity.PokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
//    private static final List<PokemonEntity> listaPokemon = new ArrayList<>();
//    private final AtomicInteger COUNTER = new AtomicInteger();
//
//
//    public PokemonEntity create (PokemonEntity pokemonEntity){
//        pokemonEntity.setIdPokemon(COUNTER.incrementAndGet());
//        listaPokemon.add(pokemonEntity);
//        return pokemonEntity;
//    }
//
//    public List<PokemonEntity> list(){return listaPokemon;}
//
//    public PokemonEntity update(Integer idPokemon, PokemonEntity pokemonAtualizar) throws RegraDeNegocioException{
//        PokemonEntity pokemonRecuperado = listaPokemon.stream()
//                .filter(pokemonEntity -> pokemonEntity.getIdPokemon().equals(idPokemon))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Pokémon não encontrado"));
//        pokemonRecuperado.setNumero(pokemonAtualizar.getNumero());
//        pokemonRecuperado.setNome(pokemonAtualizar.getNome());
//        pokemonRecuperado.setLevel(pokemonAtualizar.getLevel());
//        pokemonRecuperado.setPeso(pokemonAtualizar.getPeso());
//        pokemonRecuperado.setAltura(pokemonAtualizar.getAltura());
//        pokemonRecuperado.setCategoria(pokemonAtualizar.getCategoria());
//        pokemonRecuperado.setRegiaoDominante(pokemonAtualizar.getRegiaoDominante());
//        pokemonRecuperado.setStatus(pokemonAtualizar.getStatus());
//        return pokemonRecuperado;
//    }
//
//    public PokemonEntity getPokemonById(Integer idPokemon) throws RegraDeNegocioException {
//        return listaPokemon.stream()
//                .filter(pokemon -> pokemon.getIdPokemon().equals(idPokemon))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Pokémon não encontrado"));
//    }
//
//    public void delete(Integer idPokemon) throws RegraDeNegocioException{
//        PokemonEntity pokemonRecuperado = listaPokemon.stream()
//                .filter(pokemonEntity -> pokemonEntity.getIdPokemon().equals(idPokemon))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Pokémon não encontrado"));
//        listaPokemon.remove(pokemonRecuperado);
//    }



}
