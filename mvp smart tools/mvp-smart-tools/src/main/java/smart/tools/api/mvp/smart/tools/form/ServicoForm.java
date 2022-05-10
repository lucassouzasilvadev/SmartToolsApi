package smart.tools.api.mvp.smart.tools.form;

import lombok.Getter;
import lombok.Setter;
import smart.tools.api.mvp.smart.tools.model.*;
import smart.tools.api.mvp.smart.tools.repository.CategoriaRepository;
import smart.tools.api.mvp.smart.tools.repository.LancamentoRepository;
import smart.tools.api.mvp.smart.tools.repository.VeiculoRepository;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class ServicoForm {

    private Double valorServico;

    private String descricao;

    private String categoria;

    private String placa;

    public Servico converter(VeiculoRepository veiculoRepository, CategoriaRepository categoriaRepository, LancamentoRepository lancamentoRepository){
        Veiculo veiculo = veiculoRepository.findByPlacaVeiculo(this.placa);
        Categoria categoria = categoriaRepository.findByNome(this.categoria);
        Servico servico = new Servico();
        servico.setDataServico(LocalDate.now());
        servico.setOrdemServico(ThreadLocalRandom.current().nextInt(1, 1000));
        servico.setStatusServico(StatusServico.PENDENTE);
        servico.setValorServico(valorServico);
        servico.setDescricao(descricao);
        servico.setCategoria(categoria);
        servico.setVeiculo(veiculo);

        Lancamento lancamento = new Lancamento();
        lancamento.setTipoLancamento(TipoLancamento.RECEITA);
        lancamento.setCategoria(categoria);
        lancamento.setDescricao(this.descricao);
        lancamento.setDataRegistro(LocalDate.now());
        lancamento.setValor(this.valorServico);
        lancamentoRepository.save(lancamento);

        return servico;
    }

}
