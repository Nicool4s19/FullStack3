package cl.duoc.bernardo_ohiggins.curso_service.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "salas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSala;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nombreSala;

    @NotNull
    @Column(nullable = false)
    private Integer capacidadSala;

    @Column(length = 255)
    private String ubicacionSala;
}