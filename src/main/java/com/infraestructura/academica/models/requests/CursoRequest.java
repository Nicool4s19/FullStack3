package com.infraestructura.academica.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CursoRequest {
    
    @NotBlank(message = "El nombre del curso es obligatorio")
    private String nombre;

    private String descripcion;

    @NotNull(message = "El ID del nivel es obligatorio")
    private Long nivelId;
}
