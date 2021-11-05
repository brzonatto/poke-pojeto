package com.dbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadeDTO {

    private Integer idHabilidade;
    private String nome;
    private Double multiplicacaoDePoder;
}
