package com.dbc.repository;

import com.dbc.entity.HabilidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HabilidadeRepository extends JpaRepository<HabilidadeEntity, Integer> {
}
