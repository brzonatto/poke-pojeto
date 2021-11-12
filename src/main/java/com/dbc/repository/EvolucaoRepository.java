package com.dbc.repository;

import com.dbc.dto.EvolucaoDTO;
import com.dbc.entity.EvolucaoEntity;
import com.dbc.exceptions.RegraDeNegocioException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public interface EvolucaoRepository extends JpaRepository<EvolucaoEntity,Integer> {
//    private static List<EvolucaoEntity> evolucaoEntityList = new ArrayList<>();
//    private AtomicInteger COUNTER = new AtomicInteger();
//
//    public EvolucaoEntity create(EvolucaoEntity evolucaoEntity) {
//        evolucaoEntity.setIdEvolucao(COUNTER.incrementAndGet());
//        evolucaoEntityList.add(evolucaoEntity);
//        return evolucaoEntity;
//    }
//
//    public List<EvolucaoEntity> list() {
//        return evolucaoEntityList;
//    }
//
//    public EvolucaoEntity update(Integer idEvolucao, EvolucaoEntity evolucaoEntity) throws RegraDeNegocioException {
//        EvolucaoEntity evolucaoEntityRecuperada = evolucaoEntityList.stream()
//                .filter(evolucao -> evolucao.getIdEvolucao().equals(idEvolucao))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("evolução não encontrada"));
//        evolucaoEntityRecuperada.setEstagioUm(evolucaoEntity.getEstagioUm());
//        evolucaoEntityRecuperada.setEstagioDois(evolucaoEntity.getEstagioDois());
//        evolucaoEntityRecuperada.setEstagioTres(evolucaoEntity.getEstagioTres());
//        return evolucaoEntityRecuperada;
//    }
//
//    public void delete(Integer idEvolucao) throws RegraDeNegocioException {
//        EvolucaoEntity evolucaoEntityRecuperada = evolucaoEntityList.stream()
//                .filter(evolucao -> evolucao.getIdEvolucao().equals(idEvolucao))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("evolução não encontrada"));
//        evolucaoEntityList.remove(evolucaoEntityRecuperada);
//    }
//
//    public EvolucaoEntity getEvolucaoById(Integer idEvolucao) throws RegraDeNegocioException {
//        return evolucaoEntityList.stream()
//                .filter(evolucao -> evolucao.getIdEvolucao().equals(idEvolucao))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("evolução não encontrada"));
//    }
//
//    public EvolucaoEntity getEvolucaoByPokemon(Integer idPokemon) throws RegraDeNegocioException {
//        return evolucaoEntityList.stream()
//                .filter(evolucao -> evolucao.getEstagioUm().getIdPokemon().equals(idPokemon)
//                        || evolucao.getEstagioDois().getIdPokemon().equals(idPokemon)
//                        || evolucao.getEstagioTres().getIdPokemon().equals(idPokemon))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Evolução não encontrada"));
//    }
//
//    public Boolean existEvolucaoByPokemon(Integer idPokemon) {
//        return evolucaoEntityList.stream().anyMatch(evolucao -> {
//            if(evolucao.getEstagioUm() == null && evolucao.getEstagioDois() == null
//                    && evolucao.getEstagioTres() == null) {
//                return false;
//            }
//            if (evolucao.getEstagioTres() != null) {
//                return evolucao.getEstagioUm().getIdPokemon().equals(idPokemon) ||
//                        evolucao.getEstagioDois().getIdPokemon().equals(idPokemon) ||
//                        evolucao.getEstagioTres().getIdPokemon().equals(idPokemon);
//            }
//            return evolucao.getEstagioUm().getIdPokemon().equals(idPokemon) ||
//                    evolucao.getEstagioDois().getIdPokemon().equals(idPokemon);
//
//        });
//    }
}
