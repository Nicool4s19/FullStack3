package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    private String segundoNombre;

    @NotBlank
    @Column(nullable = false)
    private String apellido;

    private String segundoApellido;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String rut;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    private String telefono;

    @NotBlank
    @Column(nullable = false)
    private String password;

    private Boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;

}
