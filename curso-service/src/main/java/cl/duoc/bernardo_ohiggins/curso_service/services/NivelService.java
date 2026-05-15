package cl.duoc.bernardo_ohiggins.curso_service.services;

import cl.duoc.bernardo_ohiggins.curso_service.models.entities.Nivel;
import cl.duoc.bernardo_ohiggins.curso_service.models.requests.NivelRequest;
import cl.duoc.bernardo_ohiggins.curso_service.repositories.NivelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelService {

    private final NivelRepository nivelRepository;

    public NivelService(NivelRepository nivelRepository) {
        this.nivelRepository = nivelRepository;
    }

    public Nivel crear(NivelRequest request) {

        Nivel nivel = Nivel.builder()
                .nombreNivel(request.getNombreNivel())
                .descripcionNivel(request.getDescripcionNivel())
                .build();

        return nivelRepository.save(nivel);
    }

    public List<Nivel> listar() {
        return nivelRepository.findAll();
    }

    public Nivel buscarPorId(Long id) {
        return nivelRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Nivel no encontrado")
                );
    }

    public Nivel actualizar(Long id, NivelRequest request) {

        Nivel nivel = buscarPorId(id);

        nivel.setNombreNivel(request.getNombreNivel());
        nivel.setDescripcionNivel(request.getDescripcionNivel());

        return nivelRepository.save(nivel);
    }

    public void eliminar(Long id) {
        Nivel nivel = buscarPorId(id);
        nivelRepository.delete(nivel);
    }
}