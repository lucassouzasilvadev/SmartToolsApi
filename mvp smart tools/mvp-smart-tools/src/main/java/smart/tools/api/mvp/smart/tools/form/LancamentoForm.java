package smart.tools.api.mvp.smart.tools.form;

import smart.tools.api.mvp.smart.tools.model.Categoria;
import smart.tools.api.mvp.smart.tools.model.Lancamento;
import smart.tools.api.mvp.smart.tools.repository.CategoriaRepository;

public class LancamentoForm {
    private Double valor;

    private String descricao;

    private String categoria;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Lancamento converter(CategoriaRepository repository){
       Categoria categoria = repository.findByNome(this.categoria);
       return new Lancamento(valor, descricao, categoria);
    }
}
