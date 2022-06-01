package smart.tools.api.mvp.smart.tools.controller.form;

import lombok.Getter;
import lombok.Setter;
import smart.tools.api.mvp.smart.tools.model.*;
import smart.tools.api.mvp.smart.tools.repository.CategoriaRepository;
import smart.tools.api.mvp.smart.tools.repository.LancamentoRepository;
import smart.tools.api.mvp.smart.tools.repository.UsuarioRepository;
import smart.tools.api.mvp.smart.tools.repository.VeiculoRepository;
import smart.tools.api.mvp.smart.tools.service.UserService;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class ServicoForm {

    private Double valorServico;

    private String descricao;

    private String categoria;

    private String placa;

    public Servico converter(VeiculoRepository veiculoRepository, CategoriaRepository categoriaRepository, LancamentoRepository lancamentoRepository, UsuarioRepository usuarioRepository){
        Veiculo veiculo = veiculoRepository.findByPlacaVeiculo(this.placa);
        Usuario usuario = usuarioRepository.findById(UserService.authenticated().getId()).get();
        Categoria categoria = categoriaRepository.findByNome(this.categoria);
        Servico servico = new Servico();
        servico.setDataServico(LocalDate.now());
        servico.setOrdemServico(ThreadLocalRandom.current().nextInt(1, 1000));
        servico.setStatusServico(StatusServico.PENDENTE);
        servico.setValorServico(valorServico);
        servico.setDescricao(descricao);
        servico.setCategoria(categoria);
        servico.setVeiculo(veiculo);
        servico.setUsuario(usuario);

        return servico;
    }

}
