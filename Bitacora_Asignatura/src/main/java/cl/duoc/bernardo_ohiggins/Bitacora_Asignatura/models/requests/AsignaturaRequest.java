package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AsignaturaRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El código es obligatorio")
    private String codigo;

    private String descripcion;
}