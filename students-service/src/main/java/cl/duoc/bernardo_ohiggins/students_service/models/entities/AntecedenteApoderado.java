package cl.duoc.bernardo_ohiggins.students_service.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "antecedentes_apoderado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AntecedenteApoderado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedenteApoderado;

    private String nombre;
    private String ocupacion;
    private String nivelEducacional;
    private String relacionEstudiante;
    private String telefono;
    private String correo;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
}