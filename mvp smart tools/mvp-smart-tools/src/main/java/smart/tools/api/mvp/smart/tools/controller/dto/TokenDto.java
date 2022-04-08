package smart.tools.api.mvp.smart.tools.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TokenDto {

    private String token;
    private String tipo;

    public TokenDto(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

}
