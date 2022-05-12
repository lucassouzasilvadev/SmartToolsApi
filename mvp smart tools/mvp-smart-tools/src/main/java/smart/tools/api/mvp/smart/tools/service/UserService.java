package smart.tools.api.mvp.smart.tools.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import smart.tools.api.mvp.smart.tools.model.Usuario;

@Service
public class UserService {

    public static Usuario authenticated(){
        try {
            return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e) {
            return null;
        }
    }
}
