package smart.tools.api.mvp.smart.tools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smart.tools.api.mvp.smart.tools.model.Lancamento;
import smart.tools.api.mvp.smart.tools.model.Servico;
import smart.tools.api.mvp.smart.tools.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    Optional<Servico> findByVeiculoPlacaVeiculo(String placaVeiculo);

    List<Servico> findByUsuario(Usuario usuario);

}
