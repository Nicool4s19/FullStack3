package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BitacoraAsignaturaRequest {

    @NotNull(message = "El id de la asignatura es obligatorio")
    private Long idAsignatura;

    @NotBlank(message = "La observación es obligatoria")
    private String observacion;
}