package cl.duoc.bernardo_ohiggins.mensajeria_service.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CrearMensajeRequest {

    @NotNull
    private Long idRemitente;

    @NotNull
    private Long idDestinatario;

    @NotBlank
    private String asunto;

    @NotBlank
    private String contenidoMensaje;
}
