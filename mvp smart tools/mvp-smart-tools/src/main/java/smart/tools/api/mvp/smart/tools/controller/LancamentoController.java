package smart.tools.api.mvp.smart.tools.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.controller.responses.ResumoLancamento;
import smart.tools.api.mvp.smart.tools.controller.form.LancamentoForm;
import smart.tools.api.mvp.smart.tools.model.Lancamento;
import smart.tools.api.mvp.smart.tools.model.TipoLancamento;
import smart.tools.api.mvp.smart.tools.model.Usuario;
import smart.tools.api.mvp.smart.tools.repository.CategoriaRepository;
import smart.tools.api.mvp.smart.tools.repository.LancamentoRepository;
import smart.tools.api.mvp.smart.tools.repository.UsuarioRepository;
import smart.tools.api.mvp.smart.tools.service.LancamentoService;
import smart.tools.api.mvp.smart.tools.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/receitas")
    public ResponseEntity criarEntrada(@RequestBody LancamentoForm novoLancamento){
        Lancamento novaEntrada = novoLancamento.converter(categoriaRepository);
        novaEntrada.receita();
        Usuario usuario = usuarioRepository.findById(UserService.authenticated().getId()).get();
        novaEntrada.setUsuario(usuario);
        lancamentoRepository.save(novaEntrada);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEntrada);
    }


    @PostMapping("/despesas")
    public ResponseEntity criarSaida(@RequestBody LancamentoForm novoLancamento){
        Lancamento novaDespesa = novoLancamento.converter(categoriaRepository);
        novaDespesa.despesa();
        Usuario usuario = usuarioRepository.findById(UserService.authenticated().getId()).get();
        novaDespesa.setUsuario(usuario);
        lancamentoRepository.save(novaDespesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDespesa);
    }

    @GetMapping
    public ResponseEntity buscarLancamentos(String tipoLancamento){
        Usuario usuario = usuarioRepository.findById(UserService.authenticated().getId()).get();
        if (tipoLancamento == null){
            List<Lancamento> lancamentos = lancamentoRepository.findByUsuario(usuario);
            if (lancamentos.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(200).body(lancamentos);
        }

        List<Lancamento> lancamentoPorTipo = lancamentoRepository.findByTipoLancamentoAndUsuario(TipoLancamento.valueOf(tipoLancamento.toUpperCase()), usuario);
        return ResponseEntity.status(200).body(lancamentoPorTipo);
    }

    @GetMapping("/resumo")
    public ResponseEntity resumo(String dataRegistro){
            ResumoLancamento resumoLancamento = lancamentoService.resumoLancamento(dataRegistro);
            return ResponseEntity.status(200).body(resumoLancamento);
    }


    @GetMapping("/periodo")
    public ResponseEntity periodo(String dataInicio, String dataFim){
        List<Lancamento> lancamentos = lancamentoRepository.findByResumoPeriodo(LocalDate.parse(dataInicio), LocalDate.parse(dataFim));
        return ResponseEntity.ok(lancamentos);
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
