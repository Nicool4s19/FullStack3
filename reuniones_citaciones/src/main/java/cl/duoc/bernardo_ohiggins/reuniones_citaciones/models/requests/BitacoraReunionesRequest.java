package cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BitacoraReunionesRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String encargado;

    @NotNull
    @Future
    private LocalDateTime fechaReunion;
}