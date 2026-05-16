package Bernardo_Ohiggins.mural_calendario.models.requests;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CalendarioRequest {

    @NotBlank(message = "El nombre del evento es obligatorio")
    @Size(max = 100, message = "El nombre del evento no puede superar los 100 caracteres")
    private String evento;

    private String descripcion;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @NotBlank(message = "La categoría es obligatoria")
    @Size(max = 50, message = "La categoría no debe superar los 50 caracteres")
    private String categoria;
}