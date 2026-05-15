package cl.duoc.bernardo_ohiggins.curso_service.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nombreCurso;

    @Column(length = 255)
    private String descripcionCurso;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nivel_id", nullable = false)
    private Nivel nivel;
}