package cl.duoc.bernardo_ohiggins.curso_service.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "niveles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNivel;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nombreNivel;

    @Column(length = 255)
    private String descripcionNivel;
}