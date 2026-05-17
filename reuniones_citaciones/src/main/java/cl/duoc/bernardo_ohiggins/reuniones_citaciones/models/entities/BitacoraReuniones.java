package cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bitacora_reuniones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BitacoraReuniones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private String encargado;

    private LocalDateTime fechaReunion;

    private String estado;
}