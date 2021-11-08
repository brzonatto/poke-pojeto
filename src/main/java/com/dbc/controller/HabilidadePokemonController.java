package com.dbc.controller;

import com.dbc.dto.*;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.service.HabilidadePokemonService;
import com.dbc.service.HabilidadeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/habilidade/pokemon")
public class HabilidadePokemonController {

    private final HabilidadePokemonService habilidadePokemonService;

    @ApiOperation("Adicionar Habilidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Habilidade criada com sucesso!"),
            @ApiResponse(code = 400, message = "Habilidade com dados inconsistentes"),
            @ApiResponse(code = 500, message = "Exceção no sistema")
    })
    @PostMapping("/{idPokemon}")
    public HabilidadePokemonDTO create(@PathVariable("idPokemon") Integer idPokemon,
                                       @RequestBody @Valid HabilidadePokemonCreateDTO habilidadePokemonCreateDTO)
            throws RegraDeNegocioException {
        HabilidadePokemonDTO habilidadeCriada = habilidadePokemonService.create(idPokemon, habilidadePokemonCreateDTO);
        return habilidadeCriada;
    }

    @ApiOperation("Listar Habilidade")
    @GetMapping
    public List<HabilidadePokemonDTO> list() {
        return habilidadePokemonService.list();
    }


    @ApiOperation("Editar Habilidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Habilidade editada com sucesso!"),
            @ApiResponse(code = 400, message = "Habilidade não encontrada"),
            @ApiResponse(code = 500, message = "Exceção no sistema")
    })
    @PutMapping("/{idHabilidade}")
    public HabilidadePokemonDTO update(@PathVariable("idHabilidade") Integer idHabilidade,
                                       @Valid @RequestBody HabilidadePokemonCreateDTO habilidadePokemonCreateDTO)
            throws RegraDeNegocioException {
        HabilidadePokemonDTO habilidadeEditada = habilidadePokemonService
                .update(idHabilidade, habilidadePokemonCreateDTO);
        return habilidadeEditada;
    }

    @ApiOperation("Excluir Habilidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Habilidade excluída com sucesso!"),
            @ApiResponse(code = 400, message = "Habilidade não encontrada"),
            @ApiResponse(code = 500, message = "Exceção no sistema")
    })
    @DeleteMapping("/{idHabilidade}")
    public void delete(@PathVariable("idHabilidade") Integer idHabilidade) throws RegraDeNegocioException {
        habilidadePokemonService.delete(idHabilidade);
    }

    @ApiOperation("Listar por Habilidade")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Tipo não encontrado"),
            @ApiResponse(code = 500, message = "Excessão no sistema")
    })
    @GetMapping("/listarporhabilidade/{habilidade}")
    public List<PokemonDTO> listarPorTipo(@PathVariable("habilidade") String habilidade){
        return habilidadePokemonService.listarPorHabilidade(habilidade);
    }
}
