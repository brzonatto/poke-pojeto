package com.dbc.security;

import com.dbc.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenService {

    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";
    private static final String CLAIM_PERMISSOES = "permissoes";

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(UsuarioEntity usuario) {
        Date generateDate = new Date();

        //expiracao
        Date exp = new Date(generateDate.getTime() + Long.parseLong(expiration));
    }
}
