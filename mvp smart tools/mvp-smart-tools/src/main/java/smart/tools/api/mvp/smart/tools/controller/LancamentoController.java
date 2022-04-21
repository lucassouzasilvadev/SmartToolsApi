package smart.tools.api.mvp.smart.tools.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.model.Lancamento;
import smart.tools.api.mvp.smart.tools.repository.LancamentoRepository;
import smart.tools.api.mvp.smart.tools.service.LancamentoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @PostMapping("/receitas")
    public ResponseEntity criarEntrada(@RequestBody Lancamento novoLancamento){
        Lancamento novaEntrada = lancamentoService.criarEntrada(novoLancamento);
        return ResponseEntity.status(201).body(novaEntrada);
    }


    @PostMapping("/despesas")
    public ResponseEntity criarSaida(@RequestBody Lancamento novoLancamento){
        Lancamento novaDespesa = lancamentoService.criarSaida(novoLancamento);
        return ResponseEntity.status(201).body(novaDespesa);
    }

    @GetMapping
    public ResponseEntity buscarLancamentos(){
        List<Lancamento> lancamentos = lancamentoService.buscarLancamentos();
        if (lancamentos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(200).body(lancamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarLancamentoPorId(@PathVariable Integer id){
       Optional<Lancamento> lancamento = lancamentoService.buscarLancamentoPorId(id);
       return ResponseEntity.status(200).body(lancamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> atualizarLancamento(@PathVariable Integer id, @RequestBody Lancamento lancamento){
            if (!lancamentoRepository.existsById(id)){
                return ResponseEntity.notFound().build();
            }
            lancamento.setId(id);
            lancamentoRepository.save(lancamento);
            return ResponseEntity.ok(lancamento);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity excluirLancamento(@PathVariable Integer id){
        if (!lancamentoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
            lancamentoService.excluirLancamento(id);
            return ResponseEntity.noContent().build();
    }

}
