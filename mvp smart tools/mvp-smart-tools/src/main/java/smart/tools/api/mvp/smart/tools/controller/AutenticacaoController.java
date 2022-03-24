package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/autenticacao")
public class AutenticacaoController {

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody Loginorm){

    }
}
