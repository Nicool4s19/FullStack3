package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "bitacoras_asignatura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BitacoraAsignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBitacora;

    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura asignatura;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String observacion;
}