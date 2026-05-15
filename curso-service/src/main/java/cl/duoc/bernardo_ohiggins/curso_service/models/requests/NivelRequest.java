package cl.duoc.bernardo_ohiggins.curso_service.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NivelRequest {

    @NotBlank
    private String nombreNivel;

    private String descripcionNivel;
}