package smart.tools.api.mvp.smart.tools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;


@Entity
@Table(name = "tb_lancamento")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_extrato")
    private Integer id;

    @Column(name = "data_registro_extrato")
    private LocalDate dataRegistro;

    @Column(name = "valor_lancamento_extrato")
    private Double valor;

    @Column(name = "descricao_extrato")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    private Usuario usuario;


    @Enumerated(EnumType.STRING)
    private TipoLancamento tipoLancamento;

    public Lancamento(Double valor, String descricao, Categoria categoria ) {
        this.valor = valor;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public void receita(){
        setTipoLancamento(TipoLancamento.RECEITA);
        setDataRegistro(LocalDate.now());
    }

    public void despesa(){
        setTipoLancamento(TipoLancamento.DESPESA);
        setDataRegistro(LocalDate.now());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
