package com.dbc.controller;

import com.dbc.dto.UsuarioCreateDTO;
import com.dbc.dto.UsuarioDTO;
import com.dbc.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@Validated
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("/create")
    public UsuarioDTO postUsuario(@RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        return usuarioService.create(usuarioCreateDTO);
    }
}
