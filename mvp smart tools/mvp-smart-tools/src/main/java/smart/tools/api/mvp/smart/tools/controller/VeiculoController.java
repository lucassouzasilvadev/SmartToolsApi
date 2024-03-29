package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.controller.responses.ListagemServicos;
import smart.tools.api.mvp.smart.tools.controller.form.VeiculoForm;
import smart.tools.api.mvp.smart.tools.model.Servico;
import smart.tools.api.mvp.smart.tools.model.Veiculo;
import smart.tools.api.mvp.smart.tools.repository.ClienteRepository;
import smart.tools.api.mvp.smart.tools.repository.VeiculoRepository;
import smart.tools.api.mvp.smart.tools.service.VeiculoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/veiculos")
@RestController
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping
    public ResponseEntity buscarVeiculos(String placa){
        if (placa == null){
            List<Veiculo> veiculos = veiculoService.buscarVeiculos();
            if (veiculos.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(200).body(veiculos);
        }
        Veiculo veiculoPorPlaca = veiculoRepository.findByPlacaVeiculo(placa);
        return ResponseEntity.status(200).body(veiculoPorPlaca);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarVeiculoPorId(@PathVariable Integer id){
        Optional<Veiculo> veiculo = veiculoService.buscarVeiculoPorId(id);
        return ResponseEntity.status(200).body(veiculo);
    }

    @GetMapping("/servicos")
    public ResponseEntity buscarVeiculoEServico(String placaVeiculo){
        Veiculo veiculo = veiculoRepository.findByPlacaVeiculo(placaVeiculo);
        List<Servico> novo = veiculo.getServicos();
        List<ListagemServicos> lista = new ArrayList<>();
        for (Servico s : novo){
            lista.add(new ListagemServicos(s.getId(), s.getOrdemServico(), veiculo.getPlacaVeiculo(), s.getDataServico(), s.getStatusServico()));
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity cadastrarVeiculo(@RequestBody VeiculoForm veiculoForm){
        Veiculo veiculo = veiculoForm.converter(clienteRepository);
        veiculoRepository.save(veiculo);
        return ResponseEntity.status(201).body(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateVeiculo(@PathVariable Integer id, @RequestBody Veiculo atualizarVeiculo){
        if (!veiculoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        atualizarVeiculo.setIdVeiculo(id);
        veiculoRepository.save(atualizarVeiculo);
        return ResponseEntity.ok(atualizarVeiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVeiculo(@PathVariable Integer id){
        if (!veiculoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        veiculoService.excluirVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}
