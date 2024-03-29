package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.controller.form.ClienteForm;
import smart.tools.api.mvp.smart.tools.model.Cliente;
import smart.tools.api.mvp.smart.tools.model.Usuario;
import smart.tools.api.mvp.smart.tools.repository.ClienteRepository;
import smart.tools.api.mvp.smart.tools.repository.UsuarioRepository;
import smart.tools.api.mvp.smart.tools.repository.VeiculoRepository;
import smart.tools.api.mvp.smart.tools.service.ClienteService;
import smart.tools.api.mvp.smart.tools.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity listarClientes(String cpf){
        Usuario usuario = usuarioRepository.findById(UserService.authenticated().getId()).get();
        if (cpf == null){
            List<Cliente> clientes = clienteRepository.findByUsuario(usuario);
            if (clientes.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(200).body(clientes);
        }else {
            List<Cliente> cliente = clienteRepository.findByUsuarioAndCpf(usuario, cpf);
            return ResponseEntity.status(200).body(cliente);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity listarClientesPorId(@PathVariable Integer id){
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        return ResponseEntity.status(200).body(cliente);
    }

    @PostMapping
    public ResponseEntity cadastrarCliente(@RequestBody ClienteForm novoCliente){
        Cliente cliente = novoCliente.converter();
        Usuario usuario = usuarioRepository.findById(UserService.authenticated().getId()).get();
        cliente.setUsuario(usuario);
        clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCadastroCliente(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        if (!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clienteAtualizado.setId(id);
        clienteAtualizado = clienteRepository.save(clienteAtualizado);
        return ResponseEntity.status(200).body(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id){
        if (!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clienteService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }

}
