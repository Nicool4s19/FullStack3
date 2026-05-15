package cl.duoc.bernardo_ohiggins.students_service.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "antecedentes_medicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AntecedenteMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedenteMedico;

    private String enfermedad;
    private String alergias;
    private String medicamentos;
    private String tipoSangre;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
}