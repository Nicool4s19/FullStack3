package Bernardo_Ohiggins.mural_calendario.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MuralRequest {

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 150, message = "El título no puede superar los 150 caracteres")
    private String titulo;

    @NotBlank(message = "El contenido no puede estar vacío")
    private String contenido;

    @NotBlank(message = "El autor es obligatorio")
    @Size(max = 100, message = "El nombre del autor es muy largo")
    private String autor;
}