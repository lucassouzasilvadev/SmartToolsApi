package smart.tools.api.mvp.smart.tools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smart.tools.api.mvp.smart.tools.model.Lancamento;
import smart.tools.api.mvp.smart.tools.model.TipoLancamento;

import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {

    List<Lancamento> findByTipoLancamento(TipoLancamento tipoLancamento);
}
