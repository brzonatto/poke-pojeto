package com.dbc.repository;

import com.dbc.entity.EvolucaoEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EvolucaoRepository {
    private static List<EvolucaoEntity> evolucaoEntityList = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EvolucaoEntity create(EvolucaoEntity evolucaoEntity) {
        evolucaoEntity.setIdEvolucao(COUNTER.incrementAndGet());
        evolucaoEntityList.add(evolucaoEntity);
        return evolucaoEntity;
    }

    public List<EvolucaoEntity> list() {
        return evolucaoEntityList;
    }

    public EvolucaoEntity update(Integer idEvolucao, EvolucaoEntity evolucaoEntity) throws RegraDeNegocioException {
        EvolucaoEntity evolucaoEntityRecuperada = evolucaoEntityList.stream()
                .filter(evolucao -> evolucao.getIdEvolucao().equals(idEvolucao))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("evolução não encontrada"));
        evolucaoEntityRecuperada.setEstagioUm(evolucaoEntity.getEstagioUm());
        evolucaoEntityRecuperada.setEstagioDois(evolucaoEntity.getEstagioDois());
        evolucaoEntityRecuperada.setEstagioTres(evolucaoEntity.getEstagioTres());
        return evolucaoEntityRecuperada;
    }

    public void delete(Integer idEvolucao) throws RegraDeNegocioException {
        EvolucaoEntity evolucaoEntityRecuperada = evolucaoEntityList.stream()
                .filter(evolucao -> evolucao.getIdEvolucao().equals(idEvolucao))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("evolução não encontrada"));
        evolucaoEntityList.remove(evolucaoEntityRecuperada);
    }
}
