package cl.duoc.bernardo_ohiggins.students_service.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "matriculas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatricula;

    private String estadoMatricula;

    private LocalDate fechaMatricula;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
}
