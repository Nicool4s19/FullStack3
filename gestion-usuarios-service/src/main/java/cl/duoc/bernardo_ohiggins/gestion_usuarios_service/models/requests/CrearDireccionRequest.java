package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.requests;

import lombok.Data;

@Data
public class CrearDireccionRequest {

    private String calle;
    private String numero;
    private String comuna;
    private String ciudad;
    private String region;
    private String pais;
    private String codigoPostal;

}
