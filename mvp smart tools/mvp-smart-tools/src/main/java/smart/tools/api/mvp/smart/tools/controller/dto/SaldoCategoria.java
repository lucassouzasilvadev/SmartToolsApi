package smart.tools.api.mvp.smart.tools.controller.dto;

import smart.tools.api.mvp.smart.tools.model.Categoria;

public class SaldoCategoria {

    private String categoria;
    private Double valorTotal;

    public SaldoCategoria(String categoria, Double valorTotal) {
        this.categoria = categoria;
        this.valorTotal = valorTotal;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
