package smart.tools.api.mvp.smart.tools.controller.form;

import smart.tools.api.mvp.smart.tools.model.Cliente;
import smart.tools.api.mvp.smart.tools.model.Veiculo;
import smart.tools.api.mvp.smart.tools.repository.ClienteRepository;

public class VeiculoForm {

    private String marcaVeiculo;
    private String modeloVeiculo;
    private String tipoVeiculo;
    private String placaVeiculo;
    private String nomeCliente;
    private String cpfCliente;

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Veiculo converter(ClienteRepository clienteRepository) {
        Cliente cliente = clienteRepository.findByNomeAndCpf(nomeCliente, cpfCliente);
        return new Veiculo(marcaVeiculo, modeloVeiculo, tipoVeiculo, placaVeiculo, cliente);
    }
}
