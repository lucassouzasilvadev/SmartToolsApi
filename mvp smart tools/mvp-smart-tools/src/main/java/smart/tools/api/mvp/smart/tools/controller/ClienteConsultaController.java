package smart.tools.api.mvp.smart.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.tools.api.mvp.smart.tools.controller.form.AtualizarServicoForm;
import smart.tools.api.mvp.smart.tools.controller.form.ServicoForm;
import smart.tools.api.mvp.smart.tools.model.*;
import smart.tools.api.mvp.smart.tools.repository.*;
import smart.tools.api.mvp.smart.tools.service.ServicoService;
import smart.tools.api.mvp.smart.tools.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/consulta-cliente")
public class ClienteConsultaController {

    @Autowired
    private ServicoRepository servicoRepository;


    @GetMapping
    public ResponseEntity consultaServicoCliente(String placaVeiculo){
        Optional<Servico> servico = servicoRepository.findByVeiculoPlacaVeiculo(placaVeiculo);
        if (servico.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servico);
    }

}
