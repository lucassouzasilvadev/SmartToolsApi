package smart.tools.api.mvp.smart.tools.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.tools.api.mvp.smart.tools.repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void sendNewPassword(String email){

    }
}
