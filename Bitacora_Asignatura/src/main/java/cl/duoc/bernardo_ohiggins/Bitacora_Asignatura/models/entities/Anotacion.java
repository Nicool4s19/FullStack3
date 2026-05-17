package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "anotaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Anotacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnotacion;

    @Column(nullable = false)
    private String estudiante;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura asignatura;
}