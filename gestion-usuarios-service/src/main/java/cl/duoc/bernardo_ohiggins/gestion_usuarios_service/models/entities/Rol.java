package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nombreRol;

    private String descripcion;

}
