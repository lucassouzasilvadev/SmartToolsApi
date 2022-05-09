package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.controller.dto.ListagemServicos;
import smart.tools.api.mvp.smart.tools.form.ServicoForm;
import smart.tools.api.mvp.smart.tools.model.Servico;
import smart.tools.api.mvp.smart.tools.repository.CategoriaRepository;
import smart.tools.api.mvp.smart.tools.repository.LancamentoRepository;
import smart.tools.api.mvp.smart.tools.repository.ServicoRepository;
import smart.tools.api.mvp.smart.tools.repository.VeiculoRepository;
import smart.tools.api.mvp.smart.tools.service.ServicoService;

import java.time.LocalDateTime;
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

    @PostMapping
    public ResponseEntity novoServico(@RequestBody ServicoForm servicoForm){
        Servico novoServico = servicoForm.converter(veiculoRepository, categoriaRepository, lancamentoRepository);
        servicoRepository.save(novoServico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }

    @GetMapping
    public ResponseEntity buscar(){
        List<Servico> servicos =  servicoRepository.findAll();
        if (servicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/resumo")
    public ResponseEntity resumoServicos(){
        List<ListagemServicos> servico = servicoService.resumoServicos();
        if (servico.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(servico);
    }


    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
    }

}