package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.model.Usuario;
import smart.tools.api.mvp.smart.tools.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public List<Usuario> todos(){
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody Usuario novoUsuario, String senha){
        senha = passwordEncoder.encode(novoUsuario.getSenha());
        novoUsuario.setSenha(senha);
        Usuario usuario = usuarioRepository.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }
}
