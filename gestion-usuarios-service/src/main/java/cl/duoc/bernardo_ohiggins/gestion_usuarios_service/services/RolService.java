package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.services;

import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Rol;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.requests.CrearRolRequest;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.repositories.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public Rol crear(CrearRolRequest request) {
        Rol rol = Rol.builder()
                .nombreRol(request.getNombreRol())
                .descripcion(request.getDescripcion())
                .build();

        return rolRepository.save(rol);
    }

    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    public Rol buscarPorId(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

}
