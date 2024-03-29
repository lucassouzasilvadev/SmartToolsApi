package smart.tools.api.mvp.smart.tools.controller.form;

import smart.tools.api.mvp.smart.tools.model.Cliente;
import smart.tools.api.mvp.smart.tools.model.Usuario;

import javax.persistence.Column;

public class ClienteForm {

    private String nome;

    private String telefone;

    private String cpf;

    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente converter(){
        return new Cliente(nome, telefone, cpf, email);
    }


}
