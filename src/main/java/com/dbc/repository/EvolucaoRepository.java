package com.dbc.repository;

import com.dbc.entity.EvolucaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EvolucaoRepository extends JpaRepository<EvolucaoEntity,Integer> {
}
