package com.dbc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvolucaoCreateDTO {
    @NotNull
    @ApiModelProperty("Estágio básico Pokémon")
    private Integer idEstagioUm;

    @NotNull
    @ApiModelProperty("Primeira Evolução")
    private Integer idEstagioDois;

    @ApiModelProperty("Segunda Evolução")
    private Integer idEstagioTres;
}
