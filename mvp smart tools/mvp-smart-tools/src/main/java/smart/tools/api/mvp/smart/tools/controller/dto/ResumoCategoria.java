package smart.tools.api.mvp.smart.tools.controller.dto;

import smart.tools.api.mvp.smart.tools.model.Lancamento;

import java.util.ArrayList;
import java.util.List;

public class ResumoCategoria {
    private String categoria;
    private Double total;

    public ResumoCategoria(String categoria, Double total) {
        this.categoria = categoria;
        this.total = total;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
