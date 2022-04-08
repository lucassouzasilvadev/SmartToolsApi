package smart.tools.api.mvp.smart.tools.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import smart.tools.api.mvp.smart.tools.model.Usuario;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret")
    private String secret;


    public String gerarToken(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiração = new Date(hoje.getTime()  + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API SMARTTOOLS")
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiração)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
