package com.dbc.repository;

import com.dbc.entity.HabilidadePokemonEntity;
import com.dbc.entity.PokemonEntity;
import com.dbc.entity.TipoPokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class HabilidadePokemonRepository {
//    private static final List<HabilidadePokemonEntity> listaHabilidades = new ArrayList<>();
//    private final AtomicInteger COUNTER = new AtomicInteger();
//
//    public HabilidadePokemonEntity create (HabilidadePokemonEntity habilidadePokemonEntity){
//        habilidadePokemonEntity.setIdHabilidadePokemon(COUNTER.incrementAndGet());
//        listaHabilidades.add(habilidadePokemonEntity);
//        return habilidadePokemonEntity;
//    }
//
//    public List<HabilidadePokemonEntity> list(){return listaHabilidades;}
//
//    public HabilidadePokemonEntity update(Integer idHabilidade, HabilidadePokemonEntity habilidadeAtualizar)
//            throws RegraDeNegocioException {
//        HabilidadePokemonEntity habilidadeRecuperada = listaHabilidades.stream()
//                .filter(habilidadePokemonEntity-> habilidadePokemonEntity.getIdHabilidadePokemon().equals(idHabilidade))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Habilidade não encontrada"));
//        habilidadeRecuperada.setHabilidadeEntityList(habilidadeAtualizar.getHabilidadeEntityList());
//        return habilidadeRecuperada;
//    }
//
//    public HabilidadePokemonEntity getHabilidadeById(Integer idHabilidade) throws RegraDeNegocioException {
//        return listaHabilidades.stream()
//                .filter(habilidadePokemonEntity-> habilidadePokemonEntity.getIdHabilidadePokemon().equals(idHabilidade))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Habilidade não encontrada"));
//    }
//
//    public void delete(Integer idHabilidade) throws RegraDeNegocioException{
//        HabilidadePokemonEntity habilidadeRecuperada = listaHabilidades.stream()
//                .filter(habilidadePokemonEntity-> habilidadePokemonEntity.getIdHabilidadePokemon().equals(idHabilidade))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Habilidade não encontrada"));
//        listaHabilidades.remove(habilidadeRecuperada);
//    }
//
//    public Boolean existHabilidadeByPokemon(Integer idPokemon) {
//        return listaHabilidades.stream().anyMatch(habilidade -> habilidade.getPokemon().getIdPokemon().equals(idPokemon));
//    }
//
//    public HabilidadePokemonEntity getHabilidadeByPokemon(Integer idPokemon) throws RegraDeNegocioException {
//        return listaHabilidades.stream()
//                .filter(habilidade -> habilidade.getPokemon().getIdPokemon().equals(idPokemon))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Habilidade não encontrada"));
//    }
//
//    public List<PokemonEntity> listarPorHabilidade(String habilidade){
//        List<PokemonEntity> listaRetorno = new ArrayList<>();
//
//        List<HabilidadePokemonEntity> listaHabilidade = listaHabilidades.stream()
//                .filter(listaHabilidades -> listaHabilidades.getHabilidadeEntityList().
//                        get(0).toString().equals(habilidade) || listaHabilidades.getHabilidadeEntityList().
//                        get(1).toString().equals(habilidade))
//                .collect(Collectors.toList());
//
//        listaRetorno = listaHabilidade.stream().map(HabilidadePokemonEntity::getPokemon).collect(Collectors.toList());
//        return listaRetorno;
//    }


}
