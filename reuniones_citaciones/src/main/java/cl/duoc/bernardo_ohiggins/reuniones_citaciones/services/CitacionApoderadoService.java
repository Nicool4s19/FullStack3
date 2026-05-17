package cl.duoc.bernardo_ohiggins.reuniones_citaciones.services;

import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.entities.CitacionApoderado;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.requests.CitacionApoderadoRequest;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.repositories.CitacionApoderadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitacionApoderadoService {

    private final CitacionApoderadoRepository repository;

    public CitacionApoderadoService(CitacionApoderadoRepository repository) {
        this.repository = repository;
    }

    public CitacionApoderado guardar(CitacionApoderadoRequest request) {
        CitacionApoderado citacion = CitacionApoderado.builder()
                .nombreApoderado(request.getNombreApoderado())
                .nombreEstudiante(request.getNombreEstudiante())
                .motivo(request.getMotivo())
                .fechaCitacion(request.getFechaCitacion())
                .estado("PENDIENTE")
                .build();

        return repository.save(citacion);
    }

    public List<CitacionApoderado> listar() {
        return repository.findAll();
    }

    public CitacionApoderado buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Citación no encontrada"));
    }

    public CitacionApoderado editar(Long id, CitacionApoderadoRequest request) {
        CitacionApoderado citacion = buscarPorId(id);

        citacion.setNombreApoderado(request.getNombreApoderado());
        citacion.setNombreEstudiante(request.getNombreEstudiante());
        citacion.setMotivo(request.getMotivo());
        citacion.setFechaCitacion(request.getFechaCitacion());

        return repository.save(citacion);
    }

    public void eliminar(Long id) {
        CitacionApoderado citacion = buscarPorId(id);
        repository.delete(citacion);
    }
}