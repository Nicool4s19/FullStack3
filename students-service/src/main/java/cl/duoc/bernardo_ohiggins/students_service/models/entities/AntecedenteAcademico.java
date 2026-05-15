package cl.duoc.bernardo_ohiggins.students_service.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "antecedentes_academicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AntecedenteAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedenteAcademico;

    private Integer anio;
    private Double promedioFinal;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
}