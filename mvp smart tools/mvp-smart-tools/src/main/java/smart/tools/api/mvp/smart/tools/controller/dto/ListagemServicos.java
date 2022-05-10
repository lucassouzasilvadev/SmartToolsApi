package smart.tools.api.mvp.smart.tools.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smart.tools.api.mvp.smart.tools.model.StatusServico;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListagemServicos {

    private Integer ordemServico;
    private String placaCarro;
    private LocalDate data;
    private StatusServico statusServico;

}
