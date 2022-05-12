package smart.tools.api.mvp.smart.tools.controller.form;
import lombok.Getter;
import lombok.Setter;
import smart.tools.api.mvp.smart.tools.model.*;
import smart.tools.api.mvp.smart.tools.repository.ServicoRepository;


@Getter
@Setter
public class AtualizarServicoForm {
    private String statusServico;

    public Servico converter(Integer id, ServicoRepository repository){
        Servico servico = repository.findById(id).get();
        servico.setStatusServico(StatusServico.valueOf(this.statusServico.toUpperCase()));
        return servico;
    }
}
