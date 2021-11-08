package com.dbc.controller;

import com.dbc.dto.*;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.service.HabilidadePokemonService;
import com.dbc.service.HabilidadeService;
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
@RequestMapping("/habilidadepokemon")
public class HabilidadePokemonController {

    private final HabilidadePokemonService habilidadePokemonService;

    @ApiOperation("Adicionando Habilidade")
    @PostMapping
    public HabilidadePokemonDTO create(@RequestBody @Valid HabilidadePokemonCreateDTO habilidadePokemonCreateDTO) {
        HabilidadePokemonDTO habilidadeCriada = habilidadePokemonService.create(habilidadePokemonCreateDTO);
        return habilidadeCriada;
    }

    @ApiOperation("Listando Habilidade")
    @GetMapping
    public List<HabilidadePokemonDTO> list() {
        return habilidadePokemonService.list();
    }


    @ApiOperation("Editando Habilidade")
    @PutMapping("/{idHabilidade}")
    public HabilidadePokemonDTO update(@PathVariable("idHabilidade") Integer idHabilidade,
                                       @Valid @RequestBody HabilidadePokemonCreateDTO habilidadePokemonCreateDTO)
            throws RegraDeNegocioException {
        HabilidadePokemonDTO habilidadeEditada = habilidadePokemonService
                .update(idHabilidade, habilidadePokemonCreateDTO);
        return habilidadeEditada;
    }

    @ApiOperation("Excluindo Habilidade")
    @DeleteMapping("/{idHabilidade}")
    public void delete(@PathVariable("idHabilidade") Integer idHabilidade) throws RegraDeNegocioException {
        habilidadePokemonService.delete(idHabilidade);
    }
}
