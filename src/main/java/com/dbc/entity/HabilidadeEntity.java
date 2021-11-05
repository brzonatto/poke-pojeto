package com.dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadeEntity {

    @NotNull
    private Integer idHabilidade;

    @NotEmpty
    private String nome;

    @NotNull
    private Double multiplicacaoDePoder;
}
