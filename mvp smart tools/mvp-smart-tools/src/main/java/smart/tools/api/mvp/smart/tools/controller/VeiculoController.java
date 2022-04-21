package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.model.Veiculo;
import smart.tools.api.mvp.smart.tools.repository.VeiculoRepository;

import java.util.List;

@RequestMapping("/veiculos")
@RestController
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;


    @GetMapping
    public ResponseEntity buscarVeiculos(){
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return ResponseEntity.status(200).body(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarVeiculoPorId(@PathVariable Integer id){
        Veiculo veiculo = veiculoRepository.findById(id).get();
        return ResponseEntity.status(200).body(veiculo);
    }

    @PostMapping
    public ResponseEntity cadastrarVeiculo(@RequestBody Veiculo novoVeiculo){
        veiculoRepository.save(novoVeiculo);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateVeiculo(@PathVariable Integer id, @RequestBody Veiculo atualizarVeiculo){
        atualizarVeiculo.setIdVeiculo(id);
        veiculoRepository.save(atualizarVeiculo);
        return ResponseEntity.ok(atualizarVeiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVeiculo(@PathVariable Integer id){
        veiculoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
