package smart.tools.api.mvp.smart.tools.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_veiculo")
    private Integer idVeiculo;
    @Column(name = "marca_veiculo")
    private String marcaVeiculo;
    @Column(name = "modelo_veiculo")
    private String modeloVeiculo;
    @Column(name = "tipo_veiculo")
    private String tipoVeiculo;
    @Column(name = "placa_veiculo")
    private String placaVeiculo;
    @ManyToOne
    private Usuario usuario;


}
