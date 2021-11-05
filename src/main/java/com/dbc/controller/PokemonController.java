package com.dbc.controller;

import com.dbc.dto.PokemonCreateDTO;
import com.dbc.dto.PokemonDTO;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.service.PokemonService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @ApiOperation("Adicionando Pokémon")
    @PostMapping
    public PokemonDTO create (@RequestBody PokemonCreateDTO pokemonCreateDTO){
        PokemonDTO pokemonCriado = pokemonService.create(pokemonCreateDTO);
        return pokemonCriado;
    }

    @ApiOperation("Listando Pokémon")
    @GetMapping
    public List<PokemonDTO> list(){return pokemonService.list();}


    @ApiOperation("Editando Pokémon")
    @PutMapping("/{idPokemon}")
    public PokemonDTO update(@PathVariable ("idPokemon") Integer id,
                             @Valid @RequestBody PokemonCreateDTO pokemonCreateDTO) throws RegraDeNegocioException{
        PokemonDTO pokemonEditado = pokemonService.update(id, pokemonCreateDTO);
        return pokemonEditado;
    }

    @ApiOperation("Excluindo Pokémon")
    @DeleteMapping("/{idPokemon}")
    public void delete(@PathVariable("idPokemon") Integer id) throws RegraDeNegocioException{
        pokemonService.delete(id);
    }






}
