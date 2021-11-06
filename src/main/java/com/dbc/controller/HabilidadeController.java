package com.dbc.controller;

import com.dbc.dto.HabilidadeCreateDTO;
import com.dbc.dto.HabilidadeDTO;
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
    public HabilidadeDTO create (@RequestBody HabilidadeCreateDTO habilidadeCreateDTO){
        HabilidadeDTO habilidadeCriada = habilidadeService.create(habilidadeCreateDTO);
        return habilidadeCriada;
    }

    @ApiOperation("Listando Habilidade")
    @GetMapping
    public List<HabilidadeDTO> list(){return habilidadeService.list();}


    @ApiOperation("Editando Habilidade")
    @PutMapping("/{idHabilidade}")
    public HabilidadeDTO update(@PathVariable ("idHabilidade") Integer id,
                                @Valid @RequestBody HabilidadeCreateDTO habilidadeCreateDTO) throws RegraDeNegocioException {
        HabilidadeDTO habilidadeEditada = habilidadeService.update(id, habilidadeCreateDTO);
        return habilidadeEditada;
    }

    @ApiOperation("Excluindo Habilidade")
    @DeleteMapping("/{idHabilidade}")
    public void delete(@PathVariable("idHabilidade") Integer id) throws RegraDeNegocioException{
        habilidadeService.delete(id);
    }
}