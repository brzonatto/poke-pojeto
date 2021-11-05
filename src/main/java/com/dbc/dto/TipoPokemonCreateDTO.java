package com.dbc.dto;

import com.dbc.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPokemonCreateDTO {
    private List<Tipo> tipo;
}
