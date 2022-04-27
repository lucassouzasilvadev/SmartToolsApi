package smart.tools.api.mvp.smart.tools.controller.dto;

public class ResumoLancamento {


    private Double valorTotalReceitas;
    private Double valorTotalDespesas;

    public ResumoLancamento(Double valorTotalReceitas, Double valorTotalDespesas) {
        this.valorTotalReceitas = valorTotalReceitas;
        this.valorTotalDespesas = valorTotalDespesas;
    }

    public Double getValorTotalReceitas() {
        return valorTotalReceitas;
    }

    public void setValorTotalReceitas(Double valorTotalReceitas) {
        this.valorTotalReceitas = valorTotalReceitas;
    }

    public Double getValorTotalDespesas() {
        return valorTotalDespesas;
    }

    public void setValorTotalDespesas(Double valorTotalDespesas) {
        this.valorTotalDespesas = valorTotalDespesas;
    }
}
