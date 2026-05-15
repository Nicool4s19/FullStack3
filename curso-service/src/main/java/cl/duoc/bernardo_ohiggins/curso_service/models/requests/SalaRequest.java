package cl.duoc.bernardo_ohiggins.curso_service.models.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SalaRequest {

    @NotBlank
    private String nombreSala;

    @NotNull
    @Min(1)
    private Integer capacidadSala;

    private String ubicacionSala;
}