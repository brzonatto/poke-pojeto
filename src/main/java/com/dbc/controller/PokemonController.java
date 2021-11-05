package com.dbc.controller;

import com.dbc.dto.PokemonCreateDTO;
import com.dbc.dto.PokemonDTO;
import com.dbc.service.PokemonService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @ApiOperation("200")
    @PostMapping
    public PokemonDTO create (@RequestBody PokemonCreateDTO pokemonCreateDTO){
        PokemonDTO pokemonCriado = pokemonService.create(pokemonCreateDTO);
        return pokemonCriado;
    }



}
