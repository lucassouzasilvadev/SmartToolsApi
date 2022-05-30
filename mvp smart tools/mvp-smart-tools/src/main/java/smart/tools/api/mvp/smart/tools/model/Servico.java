package smart.tools.api.mvp.smart.tools.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smart.tools.api.mvp.smart.tools.service.UserService;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "tb_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer ordemServico;

    private Double valorServico;

    private String descricao;

    private LocalDate dataServico;

    @Enumerated(EnumType.STRING)
    private StatusServico statusServico;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    private Veiculo veiculo;

}
