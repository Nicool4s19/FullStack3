package cl.duoc.bernardo_ohiggins.students_service.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CrearMatriculaRequest {

    @NotNull
    private Long idEstudiante;

    private String estadoMatricula;

}
