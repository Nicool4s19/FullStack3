package cl.duoc.bernardo_ohiggins.curso_service.services;

import cl.duoc.bernardo_ohiggins.curso_service.models.entities.Sala;
import cl.duoc.bernardo_ohiggins.curso_service.models.requests.SalaRequest;
import cl.duoc.bernardo_ohiggins.curso_service.repositories.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public Sala crear(SalaRequest request) {

        Sala sala = Sala.builder()
                .nombreSala(request.getNombreSala())
                .capacidadSala(request.getCapacidadSala())
                .ubicacionSala(request.getUbicacionSala())
                .build();

        return salaRepository.save(sala);
    }

    public List<Sala> listar() {
        return salaRepository.findAll();
    }

    public Sala buscarPorId(Long id) {
        return salaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Sala no encontrada")
                );
    }

    public Sala actualizar(Long id, SalaRequest request) {

        Sala sala = buscarPorId(id);

        sala.setNombreSala(request.getNombreSala());
        sala.setCapacidadSala(request.getCapacidadSala());
        sala.setUbicacionSala(request.getUbicacionSala());

        return salaRepository.save(sala);
    }

    public void eliminar(Long id) {
        Sala sala = buscarPorId(id);
        salaRepository.delete(sala);
    }
}