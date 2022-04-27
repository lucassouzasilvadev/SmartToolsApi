package smart.tools.api.mvp.smart.tools.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Categoria {
    private String categoria;

    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria1 = (Categoria) o;
        return categoria.equals(categoria1.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria);
    }
}
