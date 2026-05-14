package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CrearUsuarioRequest {

    @NotBlank
    private String nombre;

    private String segundoNombre;

    @NotBlank
    private String apellido;

    private String segundoApellido;

    @NotBlank
    private String rut;

    @Email
    @NotBlank
    private String email;

    private String telefono;

    @NotBlank
    private String password;

    @NotNull
    private Long idRol;

    private Long idDireccion;

}
