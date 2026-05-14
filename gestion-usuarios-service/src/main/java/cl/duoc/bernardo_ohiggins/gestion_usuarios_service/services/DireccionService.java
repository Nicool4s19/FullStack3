package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.services;

import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Direccion;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.requests.CrearDireccionRequest;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.repositories.DireccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public Direccion crear(CrearDireccionRequest request) {
        Direccion direccion = Direccion.builder()
                .calle(request.getCalle())
                .numero(request.getNumero())
                .comuna(request.getComuna())
                .ciudad(request.getCiudad())
                .region(request.getRegion())
                .pais(request.getPais())
                .codigoPostal(request.getCodigoPostal())
                .build();

        return direccionRepository.save(direccion);
    }

    public List<Direccion> listar() {
        return direccionRepository.findAll();
    }

    public Direccion buscarPorId(Long id) {
        return direccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dirección no encontrada"));
    }
}
