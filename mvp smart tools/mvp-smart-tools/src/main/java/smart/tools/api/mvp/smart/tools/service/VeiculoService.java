package smart.tools.api.mvp.smart.tools.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.tools.api.mvp.smart.tools.controller.dto.ListagemServicos;
import smart.tools.api.mvp.smart.tools.model.Servico;
import smart.tools.api.mvp.smart.tools.model.StatusServico;
import smart.tools.api.mvp.smart.tools.model.Veiculo;
import smart.tools.api.mvp.smart.tools.repository.VeiculoRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
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

//    public List<ListagemServicos> resumoServicos() {
//        List<Veiculo> veiculos = veiculoRepository.findAll();
//        List<ListagemServicos> resumo = new ArrayList<>();
//        Integer ordemServico = null;
//        String placaCarro = "";
//        LocalDate data = null;
//        StatusServico statusServico = null;
//        Servico servico = null;
//
//
//        for (Veiculo s : veiculos) {
//            servico = s.getServicos().get(0);
//            ordemServico = servico.getOrdemServico();
//            placaCarro = servico.getVeiculo().getPlacaVeiculo();
//            data = servico.getDataServico();
//            statusServico = servico.getStatusServico();
//            resumo.add(new ListagemServicos(ordemServico, placaCarro, data, statusServico));
//        }
//
//        return resumo;
//    }

    @Transactional
    public void excluirVeiculo(Integer id){
        veiculoRepository.deleteById(id);
    }
}
