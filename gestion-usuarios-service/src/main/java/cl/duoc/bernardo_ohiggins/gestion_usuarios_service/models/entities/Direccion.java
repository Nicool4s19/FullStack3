package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "direcciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccion;

    private String calle;
    private String numero;
    private String comuna;
    private String ciudad;
    private String region;
    private String pais;
    private String codigoPostal;
    
}