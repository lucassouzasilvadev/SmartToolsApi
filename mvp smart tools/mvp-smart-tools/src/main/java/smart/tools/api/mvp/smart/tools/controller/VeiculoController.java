package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.model.Veiculo;
import smart.tools.api.mvp.smart.tools.repository.VeiculoRepository;
import smart.tools.api.mvp.smart.tools.service.VeiculoService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/veiculos")
@RestController
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoService veiculoService;


    @GetMapping
    public ResponseEntity buscarVeiculos(){
        List<Veiculo> veiculos = veiculoService.buscarVeiculos();
        if (veiculos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(200).body(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarVeiculoPorId(@PathVariable Integer id){
        Optional<Veiculo> veiculo = veiculoService.buscarVeiculoPorId(id);
        return ResponseEntity.status(200).body(veiculo);
    }

    @PostMapping
    public ResponseEntity cadastrarVeiculo(@RequestBody Veiculo novoVeiculo){
        Veiculo veiculo = veiculoService.cadastrarVeiculo(novoVeiculo);
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
