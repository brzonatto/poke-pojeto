package com.dbc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadePokemonCreateDTO {
    @ApiModelProperty("Lista de Habilidades")
    private List<HabilidadeDTO> habilidadeDTOList;
}
