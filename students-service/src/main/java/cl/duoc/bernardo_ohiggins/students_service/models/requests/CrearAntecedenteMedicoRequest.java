package cl.duoc.bernardo_ohiggins.students_service.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CrearAntecedenteMedicoRequest {

    @NotNull
    private Long idEstudiante;

    private String enfermedad;
    private String alergias;
    private String medicamentos;
    private String tipoSangre;
    private String observaciones;
}
