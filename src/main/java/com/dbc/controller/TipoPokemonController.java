package com.dbc.controller;

import com.dbc.dto.TipoPokemonCreateDTO;
import com.dbc.dto.TipoPokemonDTO;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.service.TipoPokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo")
@Validated
@RequiredArgsConstructor
@Slf4j
public class TipoPokemonController {
    private final TipoPokemonService tipoPokemonService;

    @PostMapping("/{idPokemon}")
    public TipoPokemonDTO create(@PathVariable Integer idPokemon, @RequestBody TipoPokemonCreateDTO tipoPokemonCreateDTO) throws RegraDeNegocioException {
        TipoPokemonDTO tipoPokemonDTOCriado = tipoPokemonService.create(idPokemon, tipoPokemonCreateDTO);
        return tipoPokemonDTOCriado;
    }
}
