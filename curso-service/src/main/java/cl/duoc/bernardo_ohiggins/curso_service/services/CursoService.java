package cl.duoc.bernardo_ohiggins.curso_service.services;

import cl.duoc.bernardo_ohiggins.curso_service.models.entities.Curso;
import cl.duoc.bernardo_ohiggins.curso_service.models.entities.Nivel;
import cl.duoc.bernardo_ohiggins.curso_service.models.requests.CursoRequest;
import cl.duoc.bernardo_ohiggins.curso_service.repositories.CursoRepository;
import cl.duoc.bernardo_ohiggins.curso_service.repositories.NivelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final NivelRepository nivelRepository;

    public CursoService(CursoRepository cursoRepository,
                        NivelRepository nivelRepository) {
        this.cursoRepository = cursoRepository;
        this.nivelRepository = nivelRepository;
    }

    public Curso crear(CursoRequest request) {

        Nivel nivel = nivelRepository.findById(
                Objects.requireNonNull(request.getIdNivel())
        ).orElseThrow(() ->
                new RuntimeException("Nivel no encontrado")
        );

        Curso curso = Curso.builder()
                .nombreCurso(request.getNombreCurso())
                .descripcionCurso(request.getDescripcionCurso())
                .nivel(nivel)
                .build();

        return cursoRepository.save(curso);
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Curso no encontrado")
                );
    }

    public Curso actualizar(Long id, CursoRequest request) {

        Curso curso = buscarPorId(id);

        Nivel nivel = nivelRepository.findById(
                Objects.requireNonNull(request.getIdNivel())
        ).orElseThrow(() ->
                new RuntimeException("Nivel no encontrado")
        );

        curso.setNombreCurso(request.getNombreCurso());
        curso.setDescripcionCurso(request.getDescripcionCurso());
        curso.setNivel(nivel);

        return cursoRepository.save(curso);
    }

    public void eliminar(Long id) {
        Curso curso = buscarPorId(id);
        cursoRepository.delete(curso);
    }
}