package smart.tools.api.mvp.smart.tools.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
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

}
