package cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bitacora_reunion_general")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BitacoraReunionGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tema;

    private String observacion;

    private String participantes;

    private LocalDateTime fechaRegistro;
}