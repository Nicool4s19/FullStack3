package cl.duoc.bernardo_ohiggins.students_service.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CrearEstudianteRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String rut;

    private LocalDate fechaNacimiento;

    private String estado;

    private Long idUsuario;

}
