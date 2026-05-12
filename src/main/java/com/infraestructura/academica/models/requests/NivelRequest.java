package com.infraestructura.academica.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NivelRequest {
    
    @NotBlank(message = "El nombre del nivel es obligatorio")
    private String nombre;

    private String descripcion;
}
