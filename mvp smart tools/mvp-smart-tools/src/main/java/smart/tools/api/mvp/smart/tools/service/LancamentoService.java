package smart.tools.api.mvp.smart.tools.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.tools.api.mvp.smart.tools.model.Lancamento;
import smart.tools.api.mvp.smart.tools.repository.LancamentoRepository;

import javax.transaction.Transactional;
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
    
}
