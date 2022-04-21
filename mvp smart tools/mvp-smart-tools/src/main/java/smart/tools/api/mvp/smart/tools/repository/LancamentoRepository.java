package smart.tools.api.mvp.smart.tools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smart.tools.api.mvp.smart.tools.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
}
