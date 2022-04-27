package smart.tools.api.mvp.smart.tools.form;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import smart.tools.api.mvp.smart.tools.model.Usuario;

public class UsuarioForm {

    private String nomeOficina;

    private String cnpj;

    private String telefone;

    private String email;

    private String senha;


    public String getNomeOficina() {
        return nomeOficina;
    }

    public void setNomeOficina(String nomeOficina) {
        this.nomeOficina = nomeOficina;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario converter(BCryptPasswordEncoder encoder){
        String senhaEncode = encoder.encode(senha);
        return new Usuario(nomeOficina, cnpj, telefone, email, senhaEncode);
    }
}
