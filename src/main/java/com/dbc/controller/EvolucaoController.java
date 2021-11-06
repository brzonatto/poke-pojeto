package com.dbc.controller;

import com.dbc.dto.EvolucaoCreateDTO;
import com.dbc.dto.EvolucaoDTO;
import com.dbc.exceptions.RegraDeNegocioException;
import com.dbc.service.EvolucaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evolucao")
@Validated
@RequiredArgsConstructor
@Slf4j
public class EvolucaoController {
    private final EvolucaoService evolucaoService;

    @PostMapping
    public EvolucaoDTO create(@RequestBody EvolucaoCreateDTO evolucaoCreateDTO) throws RegraDeNegocioException {
        EvolucaoDTO evolucaoDTOCriado = evolucaoService.create(evolucaoCreateDTO);
        return evolucaoDTOCriado;
    }

    @GetMapping
    public List<EvolucaoDTO> list() {
        return evolucaoService.list();
    }

    @PutMapping("/{idEvolucao}")
    public EvolucaoDTO update(@PathVariable("idEvolucao") Integer idEvolucao, @RequestBody EvolucaoCreateDTO evolucaoCreateDTO) throws RegraDeNegocioException {
        return evolucaoService.update(idEvolucao, evolucaoCreateDTO);
    }

    @DeleteMapping("/{idEvolucao}")
    public void delete(@PathVariable("idEvolucao") Integer idEvolucao) throws RegraDeNegocioException {
        evolucaoService.delete(idEvolucao);
    }
}
