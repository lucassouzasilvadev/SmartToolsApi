package smart.tools.api.mvp.smart.tools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import smart.tools.api.mvp.smart.tools.model.Cliente;
import smart.tools.api.mvp.smart.tools.model.Lancamento;
import smart.tools.api.mvp.smart.tools.model.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByEmail(String email);

    List<Cliente> findByCpf(String cpf);

    Cliente findByNomeAndCpf(String nome, String cpf);

    List<Cliente> findByUsuario(Usuario usuario);

    List<Cliente> findByUsuarioAndCpf(Usuario usuario, String cpf);

}
