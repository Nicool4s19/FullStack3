package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.services;

import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities.Asignatura;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.requests.AsignaturaRequest;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.repositories.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    public Asignatura guardar(AsignaturaRequest request) {
        Asignatura asignatura = Asignatura.builder()
                .nombre(request.getNombre())
                .codigo(request.getCodigo())
                .descripcion(request.getDescripcion())
                .build();

        return asignaturaRepository.save(asignatura);
    }

    public List<Asignatura> listar() {
        return asignaturaRepository.findAll();
    }

    public Asignatura buscarPorId(Long id) {
        return asignaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
    }

    public void eliminar(Long id) {
        asignaturaRepository.deleteById(id);
    }
}