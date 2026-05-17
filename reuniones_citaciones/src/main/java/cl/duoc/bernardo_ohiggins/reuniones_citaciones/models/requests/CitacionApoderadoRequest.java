package cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CitacionApoderadoRequest {

    @NotBlank
    private String nombreApoderado;

    @NotBlank
    private String nombreEstudiante;

    @NotBlank
    private String motivo;

    @NotNull
    @Future
    private LocalDateTime fechaCitacion;
}