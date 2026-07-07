package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private String token;
    private String rol;

}