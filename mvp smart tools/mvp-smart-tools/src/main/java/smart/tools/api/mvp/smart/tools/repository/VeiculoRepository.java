package smart.tools.api.mvp.smart.tools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import smart.tools.api.mvp.smart.tools.model.Lancamento;
import smart.tools.api.mvp.smart.tools.model.Servico;
import smart.tools.api.mvp.smart.tools.model.Veiculo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    Veiculo findByPlacaVeiculo(String placa);


}
