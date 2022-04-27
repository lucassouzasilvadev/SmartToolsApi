package smart.tools.api.mvp.smart.tools.controller.dto;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumoCategoria that = (ResumoCategoria) o;
        return Objects.equals(categoria, that.categoria) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria, total);
    }
}
