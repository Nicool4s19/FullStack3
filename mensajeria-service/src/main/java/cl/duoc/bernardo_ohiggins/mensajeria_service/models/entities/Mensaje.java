package cl.duoc.bernardo_ohiggins.mensajeria_service.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMensaje;

    @NotNull
    @Column(nullable = false)
    private Long idRemitente;

    @NotNull
    @Column(nullable = false)
    private Long idDestinatario;

    @NotBlank
    @Column(nullable = false)
    private String asunto;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenidoMensaje;

    private LocalDateTime fechaMensaje;

    private Boolean leido;

    private String estadoMensaje;
}