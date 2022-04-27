package smart.tools.api.mvp.smart.tools.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.tools.api.mvp.smart.tools.controller.dto.ResumoLancamento;
import smart.tools.api.mvp.smart.tools.model.Lancamento;
import smart.tools.api.mvp.smart.tools.model.TipoLancamento;
import smart.tools.api.mvp.smart.tools.repository.LancamentoRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Transactional
    public Lancamento criarEntrada(Lancamento lancamento){
        lancamento.receita();
        return lancamentoRepository.save(lancamento);
    }

    @Transactional
    public Lancamento criarSaida(Lancamento lancamento){
        lancamento.despesa();
        return lancamentoRepository.save(lancamento);
    }

    public List<Lancamento> buscarLancamentos(){
        return lancamentoRepository.findAll();
    }
    
    public Optional<Lancamento> buscarLancamentoPorId(Integer id){
        boolean idExiste = lancamentoRepository.existsById(id);
        if (!idExiste){
            return null;
        }
        return lancamentoRepository.findById(id);
    }
    
    @Transactional
    public void excluirLancamento(Integer id){
        lancamentoRepository.deleteById(id);
    }

    public ResumoLancamento resumoLancamento(String dataRegistro) {
        if (dataRegistro == null) {
            List<Lancamento> lancamentos = lancamentoRepository.findAll();
            Double totalReceitas = 0.0;
            Double totalDespesas = 0.0;

            for (Lancamento lancamento : lancamentos) {
                if (lancamento.getTipoLancamento() == TipoLancamento.DESPESA) {
                    totalDespesas += lancamento.getValor();
                } else if (lancamento.getTipoLancamento() == TipoLancamento.RECEITA) {
                    totalReceitas += lancamento.getValor();
                }
            }
            return new ResumoLancamento(totalReceitas, totalDespesas);
        }
        List<Lancamento> resumoPorData = lancamentoRepository.findBydataRegistro(LocalDate.parse(dataRegistro));
        Double totalReceitas = 0.0;
        Double totalDespesas = 0.0;
        for(Lancamento lancamento : resumoPorData){
            if (lancamento.getTipoLancamento() == TipoLancamento.DESPESA){
                totalDespesas += lancamento.getValor();
            } else if (lancamento.getTipoLancamento() == TipoLancamento.RECEITA) {
                totalReceitas += lancamento.getValor();
            }
        }
        return new ResumoLancamento(totalReceitas, totalDespesas);
    }

    public ResumoLancamento resumoPeriodo(String dataInicio, String dataFim) {
        List<Lancamento> lancamentos = lancamentoRepository.findByResumoPeriodo(LocalDate.parse(dataInicio), LocalDate.parse(dataFim));
        Double totalReceitas = 0.0;
        Double totalDespesas = 0.0;
        for (Lancamento lancamento : lancamentos) {
            if (lancamento.getTipoLancamento() == TipoLancamento.DESPESA) {
                totalDespesas += lancamento.getValor();
            } else if (lancamento.getTipoLancamento() == TipoLancamento.RECEITA) {
                totalReceitas += lancamento.getValor();
            }
        }
        return new ResumoLancamento(totalReceitas, totalDespesas);
    }
}
