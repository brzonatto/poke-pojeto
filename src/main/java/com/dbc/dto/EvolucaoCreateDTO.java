package com.dbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvolucaoCreateDTO {
    @NotNull
    private Integer idEstagioUm;

    @NotNull
    private Integer idEstagioDois;

    private Integer idEstagioTres;
}
