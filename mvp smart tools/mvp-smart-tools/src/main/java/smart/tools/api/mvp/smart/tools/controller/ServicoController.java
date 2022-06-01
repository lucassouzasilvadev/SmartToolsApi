package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.controller.form.AtualizarServicoForm;
import smart.tools.api.mvp.smart.tools.controller.form.ServicoForm;
import smart.tools.api.mvp.smart.tools.model.*;
import smart.tools.api.mvp.smart.tools.repository.*;
import smart.tools.api.mvp.smart.tools.service.ServicoService;
import smart.tools.api.mvp.smart.tools.service.UserService;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity novoServico(@RequestBody ServicoForm servicoForm){
        Servico novoServico = servicoForm.converter(veiculoRepository, categoriaRepository, lancamentoRepository);
        Lancamento lancamento = new Lancamento();
        Categoria categoria = categoriaRepository.findByNome(servicoForm.getCategoria());
        lancamento.setTipoLancamento(TipoLancamento.RECEITA);
        lancamento.setCategoria(categoria);
        lancamento.setDescricao(servicoForm.getDescricao());
        lancamento.setDataRegistro(LocalDate.now());
        lancamento.setValor(servicoForm.getValorServico());
        Usuario usuario = usuarioRepository.findById(UserService.authenticated().getId()).get();
        lancamento.setUsuario(usuario);
        lancamentoRepository.save(lancamento);
        servicoRepository.save(novoServico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }

    @GetMapping
    public ResponseEntity buscar(){
        Usuario usuario = usuarioRepository.findById(UserService.authenticated().getId()).get();
        List<Servico> servicos =  servicoRepository.findByUsuario(usuario);
        if (servicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(servicos);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarStatusServico(@PathVariable Integer id, @RequestBody AtualizarServicoForm update){
        Servico servico = update.converter(id, servicoRepository);
        servicoRepository.save(servico);
        return ResponseEntity.ok(servico);
    }

//    @GetMapping("/consulta-cliente")
//    public ResponseEntity consultaServicoCliente(String placaVeiculo){
//        Servico servico = servicoRepository.findByVeiculo_placaVeiculo(placaVeiculo);
//        if (servicoRepository.existsById(servico.getId())){
//            return ResponseEntity.ok(servico);
//        }
//        return ResponseEntity.notFound().build();
//    }



}
