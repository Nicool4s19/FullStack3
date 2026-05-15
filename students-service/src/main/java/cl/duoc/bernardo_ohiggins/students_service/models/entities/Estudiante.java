package cl.duoc.bernardo_ohiggins.students_service.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String apellido;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String rut;

    private LocalDate fechaNacimiento;

    private String estado;

    private Long idUsuario;
}
