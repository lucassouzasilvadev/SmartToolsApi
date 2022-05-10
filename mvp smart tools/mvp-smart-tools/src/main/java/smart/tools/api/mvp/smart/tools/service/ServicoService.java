package smart.tools.api.mvp.smart.tools.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.tools.api.mvp.smart.tools.controller.dto.ListagemServicos;
import smart.tools.api.mvp.smart.tools.controller.dto.ResumoLancamento;
import smart.tools.api.mvp.smart.tools.model.Lancamento;
import smart.tools.api.mvp.smart.tools.model.Servico;
import smart.tools.api.mvp.smart.tools.model.StatusServico;
import smart.tools.api.mvp.smart.tools.model.TipoLancamento;
import smart.tools.api.mvp.smart.tools.repository.ServicoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;


//    public List<ListagemServicos> resumoServicos() {
//            List<Servico> servicos = servicoRepository.findAll();
//            List<ListagemServicos> resumo = new ArrayList<>();
//            Integer ordemServico = null;
//            String placaCarro = "";
//            LocalDate data = null;
//            StatusServico statusServico = null;
//
//            for (Servico s : servicos) {
//                ordemServico = s.getOrdemServico();
//                placaCarro = s.getVeiculo().getPlacaVeiculo();
//                data = s.getDataServico();
//                statusServico = s.getStatusServico();
//                resumo.add(new ListagemServicos(ordemServico, placaCarro, data, statusServico));
//            }
//
////            ListagemServicos list =
//
//            return resumo;
//    }

}
