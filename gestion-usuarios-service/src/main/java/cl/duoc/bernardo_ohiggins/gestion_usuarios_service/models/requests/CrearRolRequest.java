package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CrearRolRequest {

    @NotBlank
    private String nombreRol;

    private String descripcion;

}
