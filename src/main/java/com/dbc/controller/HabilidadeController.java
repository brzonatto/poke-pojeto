package com.dbc.controller;

import com.dbc.dto.HabilidadeCreateDTO;
import com.dbc.dto.HabilidadeDTO;
import com.dbc.dto.PokemonDTO;
import com.dbc.exceptions.RegraDeNegocioException;
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
@RequestMapping("/habilidade")
public class HabilidadeController {

    private final HabilidadeService habilidadeService;

    @ApiOperation("Adicionando Habilidade")
    @PostMapping
    public HabilidadeDTO create (@RequestBody @Valid HabilidadeCreateDTO habilidadeCreateDTO){
        HabilidadeDTO habilidadeCriada = habilidadeService.create(habilidadeCreateDTO);
        return habilidadeCriada;
    }

    @ApiOperation("Listando Habilidade")
    @GetMapping
    public List<HabilidadeDTO> list(){return habilidadeService.list();}


    @ApiOperation("Editando Habilidade")
    @PutMapping("/{idHabilidade}")
    public HabilidadeDTO update(@PathVariable("idHabilidade") Integer idHabilidade,
                                @Valid @RequestBody HabilidadeCreateDTO habilidadeCreateDTO) throws RegraDeNegocioException {
        HabilidadeDTO habilidadeEditada = habilidadeService.update(idHabilidade, habilidadeCreateDTO);
        return habilidadeEditada;
    }

    @ApiOperation("Excluindo Habilidade")
    @DeleteMapping("/{idHabilidade}")
    public void delete(@PathVariable("idHabilidade") Integer idHabilidade) throws RegraDeNegocioException{
        habilidadeService.delete(idHabilidade);
    }

//    @ApiOperation("Listando por Habilidade")
//    @GetMapping("listarporhabilidade/{habilidade}")
//    public List<PokemonDTO> listarPokemonHabilidade(@PathVariable("habilidade") String habilidade){
//        return habilidadeService.listarPorHabilidade(habilidade);
//    }
}
