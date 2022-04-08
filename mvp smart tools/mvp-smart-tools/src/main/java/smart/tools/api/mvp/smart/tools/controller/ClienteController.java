package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.model.Cliente;
import smart.tools.api.mvp.smart.tools.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity listar(){
        List<Cliente> clientes = new ArrayList<>();
        if (!clientes.isEmpty()){
            return ResponseEntity.status(200).body(clientes);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity listarClientesPorId(@PathVariable Integer id){
        Cliente cliente = new Cliente();
        if (cliente.getId().equals(id)){
            return ResponseEntity.status(200).body(clienteRepository.findById(id));
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente novoCliente){
        boolean emailEmUso = clienteRepository.findByEmail(novoCliente.getEmail())
                .stream()
                .anyMatch(clienteExiste -> !clienteExiste.equals(novoCliente));

        if (emailEmUso){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCadastroCliente(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        if (!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clienteAtualizado.setId(id);
        clienteRepository.save(clienteAtualizado);
        return ResponseEntity.status(200).body(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id){
        if (!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
