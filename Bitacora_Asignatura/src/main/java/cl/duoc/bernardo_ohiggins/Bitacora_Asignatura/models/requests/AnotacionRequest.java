package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnotacionRequest {

    @NotBlank(message = "El estudiante es obligatorio")
    private String estudiante;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "El id de la asignatura es obligatorio")
    private Long idAsignatura;
}