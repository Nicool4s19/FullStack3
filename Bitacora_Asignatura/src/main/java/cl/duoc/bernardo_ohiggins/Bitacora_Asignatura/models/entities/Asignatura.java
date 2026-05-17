package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "asignaturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsignatura;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String codigo;

    private String descripcion;
}