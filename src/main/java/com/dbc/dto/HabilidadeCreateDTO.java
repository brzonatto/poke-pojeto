package com.dbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadeCreateDTO {
    @NotEmpty
    @NotBlank
    private String nome;

    @NotNull
    private Double multiplicacaoDePoder;
}
