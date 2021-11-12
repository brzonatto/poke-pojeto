package com.dbc.repository;
import com.dbc.entity.TipoPokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoPokemonRepository extends JpaRepository<TipoPokemonEntity, Integer> {
}
