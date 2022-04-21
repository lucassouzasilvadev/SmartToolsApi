package smart.tools.api.mvp.smart.tools.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.tools.api.mvp.smart.tools.model.Veiculo;
import smart.tools.api.mvp.smart.tools.repository.VeiculoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional
    public Veiculo cadastrarVeiculo(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> buscarVeiculos(){
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarVeiculoPorId(Integer id){
        boolean idExiste = veiculoRepository.existsById(id);
        if (!idExiste){
            return null;
        }
        return veiculoRepository.findById(id);
    }

    @Transactional
    public void excluirVeiculo(Integer id){
        veiculoRepository.deleteById(id);
    }
}
