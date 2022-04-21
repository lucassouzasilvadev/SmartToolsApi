package smart.tools.api.mvp.smart.tools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;


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
    private OffsetDateTime dataRegistro;

    @Column(name = "valor_lancamento_extrato")
    private Double valor;

    @Column(name = "descricao_extrato")
    private String descricao;

    @Column(name = "categoria_extrato")
    private String categoria;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipoLancamento;

    public void receita(){
        setTipoLancamento(TipoLancamento.RECEITA);
        setDataRegistro(OffsetDateTime.now());
    }

    public void despesa(){
        setTipoLancamento(TipoLancamento.DESPESA);
        setDataRegistro(OffsetDateTime.now());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OffsetDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(OffsetDateTime dataRegistro) {
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }
}
