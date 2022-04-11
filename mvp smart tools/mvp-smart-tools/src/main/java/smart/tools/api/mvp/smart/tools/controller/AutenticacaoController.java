package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smart.tools.api.mvp.smart.tools.config.security.TokenService;
import smart.tools.api.mvp.smart.tools.controller.dto.TokenDto;
import smart.tools.api.mvp.smart.tools.form.LoginForm;


@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Validated LoginForm form){
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {
            Authentication authentication =  authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
