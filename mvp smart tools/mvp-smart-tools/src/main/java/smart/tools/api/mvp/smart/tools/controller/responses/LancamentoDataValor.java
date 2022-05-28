package smart.tools.api.mvp.smart.tools.controller.responses;


import java.time.LocalDate;

public class LancamentoDataValor {

    private Integer id;
    private Double valor;
    private LocalDate data;
    private Boolean isDespesa;

    public LancamentoDataValor(Integer id, Double valor, LocalDate data, Boolean isDespesa) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.isDespesa = isDespesa;
    }
}
