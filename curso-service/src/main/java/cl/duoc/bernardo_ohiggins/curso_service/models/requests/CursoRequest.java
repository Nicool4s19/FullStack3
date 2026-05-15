package cl.duoc.bernardo_ohiggins.curso_service.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CursoRequest {

    @NotBlank
    private String nombreCurso;

    private String descripcionCurso;

    @NotNull
    private Long idNivel;
}