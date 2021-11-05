package com.dbc.controller;

import com.dbc.dto.TipoPokemonCreateDTO;
import com.dbc.dto.TipoPokemonDTO;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.service.TipoPokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<TipoPokemonDTO> list() {
        return tipoPokemonService.list();
    }

    @PutMapping("/{idTipo}")
    public TipoPokemonDTO update(@PathVariable Integer idTipo, @RequestBody TipoPokemonCreateDTO tipoPokemonCreateDTO) throws RegraDeNegocioException {
        return tipoPokemonService.update(idTipo, tipoPokemonCreateDTO);
    }

    @DeleteMapping("/{idTipo}")
    public void delete(@PathVariable Integer idTipo) throws RegraDeNegocioException {
        tipoPokemonService.delete(idTipo);
    }
}
