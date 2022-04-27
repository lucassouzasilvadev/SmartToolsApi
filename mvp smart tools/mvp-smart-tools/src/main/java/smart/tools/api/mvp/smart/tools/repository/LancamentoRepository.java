package smart.tools.api.mvp.smart.tools.repository;

import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import smart.tools.api.mvp.smart.tools.controller.dto.ResumoCategoria;
import smart.tools.api.mvp.smart.tools.model.Lancamento;
import smart.tools.api.mvp.smart.tools.model.TipoLancamento;

import java.time.LocalDate;
import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {

    List<Lancamento> findByTipoLancamento(TipoLancamento tipoLancamento);

    List<Lancamento> findBydataRegistro(LocalDate dataRegistro);

    @Query("SELECT e from Lancamento e where e.dataRegistro Between :dataInicio and :dataFim")
    List<Lancamento> findByResumoPeriodo(LocalDate dataInicio, LocalDate dataFim);

    List<Lancamento> findByCategoria(String categoria);

}
