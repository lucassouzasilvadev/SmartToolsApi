package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.form.UsuarioForm;
import smart.tools.api.mvp.smart.tools.model.Usuario;
import smart.tools.api.mvp.smart.tools.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity cadastrarUsuario(@RequestBody UsuarioForm novoUsuario){
        Usuario usuario = novoUsuario.converter(passwordEncoder);
        Optional<Usuario> emailUsuario = usuarioRepository.findByEmail(usuario.getEmail());
        if (!emailUsuario.isPresent()){
            usuarioRepository.save(usuario);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.ok("usuário já existe");
    }
}
