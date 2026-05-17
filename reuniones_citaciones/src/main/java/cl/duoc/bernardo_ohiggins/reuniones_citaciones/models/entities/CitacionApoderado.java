package cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "citacion_apoderado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitacionApoderado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreApoderado;

    private String nombreEstudiante;

    private String motivo;

    private LocalDateTime fechaCitacion;

    private String estado;
}