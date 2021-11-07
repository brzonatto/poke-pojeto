package com.dbc.repository;

import com.dbc.entity.HabilidadeEntity;
import com.dbc.entity.PokemonEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class HabilidadeRepository {
    private static final List<HabilidadeEntity> listaHabilidades = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public HabilidadeEntity create (HabilidadeEntity habilidadeEntity){
        habilidadeEntity.setIdHabilidade(COUNTER.incrementAndGet());
        listaHabilidades.add(habilidadeEntity);
        return habilidadeEntity;
    }

    public List<HabilidadeEntity> list(){return listaHabilidades;}

    public HabilidadeEntity update(Integer idHabilidade, HabilidadeEntity habilidadeAtualizar) throws RegraDeNegocioException {
        HabilidadeEntity habilidadeRecuperada = listaHabilidades.stream()
                .filter(habilidadeEntity-> habilidadeEntity.getIdHabilidade().equals(idHabilidade))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Habilidade não encontrada"));
        habilidadeRecuperada.setNome(habilidadeAtualizar.getNome());
        habilidadeRecuperada.setMultiplicacaoDePoder(habilidadeAtualizar.getMultiplicacaoDePoder());
        return habilidadeRecuperada;
    }

    public HabilidadeEntity getHabilidadeById(Integer idHabilidade) throws RegraDeNegocioException {
        return listaHabilidades.stream()
                .filter(habilidadeEntity-> habilidadeEntity.getIdHabilidade().equals(idHabilidade))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Habilidade não encontrada"));
    }

    public void delete(Integer idHabilidade) throws RegraDeNegocioException{
        HabilidadeEntity habilidadeRecuperada= listaHabilidades.stream()
                .filter(habilidadeEntity-> habilidadeEntity.getIdHabilidade().equals(idHabilidade))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Habilidade não encontrada"));
        listaHabilidades.remove(habilidadeRecuperada);
    }

    public List<PokemonEntity> listarPorHabilidade(String habilidade){
        List<PokemonEntity> listaRetorno = new ArrayList<>();

        List<HabilidadeEntity> listaHabilidade = listaHabilidades.stream()
                .filter(listaHabilidades -> listaHabilidades.getNome().equals(habilidade))
                .collect(Collectors.toList());

        listaRetorno = listaHabilidade.stream().map(habilidadeEntity -> habilidadeEntity.getPokemon()).collect(Collectors.toList());
        return listaRetorno;
    }
}
