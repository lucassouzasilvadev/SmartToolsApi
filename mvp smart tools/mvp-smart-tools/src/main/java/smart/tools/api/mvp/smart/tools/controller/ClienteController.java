package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.controller.dto.ListagemServicos;
import smart.tools.api.mvp.smart.tools.form.ClienteForm;
import smart.tools.api.mvp.smart.tools.model.Cliente;
import smart.tools.api.mvp.smart.tools.model.Veiculo;
import smart.tools.api.mvp.smart.tools.repository.ClienteRepository;
import smart.tools.api.mvp.smart.tools.repository.VeiculoRepository;
import smart.tools.api.mvp.smart.tools.service.ClienteService;

import java.util.ArrayList;
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

    @GetMapping
    public ResponseEntity listarClientes(String cpf){
        if (cpf == null){
            List<Cliente> clientes = clienteService.buscarClientes();
            if (clientes.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(200).body(clientes);
        }else {
            List<Cliente> cliente = clienteRepository.findByCpf(cpf);
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
