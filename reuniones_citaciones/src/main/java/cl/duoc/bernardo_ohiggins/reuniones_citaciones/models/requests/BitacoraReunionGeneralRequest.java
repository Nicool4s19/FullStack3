package cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BitacoraReunionGeneralRequest {

    @NotBlank
    private String tema;

    @NotBlank
    private String observacion;

    @NotBlank
    private String participantes;
}