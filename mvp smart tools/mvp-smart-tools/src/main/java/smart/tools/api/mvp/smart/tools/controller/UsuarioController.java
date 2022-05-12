package smart.tools.api.mvp.smart.tools.controller;

import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.controller.form.UsuarioForm;
import smart.tools.api.mvp.smart.tools.model.Usuario;
import smart.tools.api.mvp.smart.tools.repository.UsuarioRepository;
import smart.tools.api.mvp.smart.tools.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

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

    @PutMapping("/{id}")
    public ResponseEntity atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario updateUser = usuarioRepository.findById(id).get();
        if (!updateUser.getId().equals(id)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updateUser);
    }
}
