package cl.duoc.bernardo_ohiggins.students_service.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "hojas_vida_estudiante")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HojaVidaEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHojaVida;

    private LocalDate fechaCreacion;

    @Column(columnDefinition = "TEXT")
    private String observacionesGenerales;

    @OneToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

}
