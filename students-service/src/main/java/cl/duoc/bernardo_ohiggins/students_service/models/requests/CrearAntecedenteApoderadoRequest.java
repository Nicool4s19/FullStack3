package cl.duoc.bernardo_ohiggins.students_service.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CrearAntecedenteApoderadoRequest {

    @NotNull
    private Long idEstudiante;

    private String nombre;
    private String ocupacion;
    private String nivelEducacional;
    private String relacionEstudiante;
    private String telefono;
    private String correo;
    private String observaciones;
}
