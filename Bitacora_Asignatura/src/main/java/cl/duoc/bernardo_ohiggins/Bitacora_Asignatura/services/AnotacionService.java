package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.services;

import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities.Anotacion;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities.Asignatura;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.requests.AnotacionRequest;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.repositories.AnotacionRepository;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.repositories.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AnotacionService {

    private final AnotacionRepository anotacionRepository;
    private final AsignaturaRepository asignaturaRepository;

    public AnotacionService(AnotacionRepository anotacionRepository,
                            AsignaturaRepository asignaturaRepository) {
        this.anotacionRepository = anotacionRepository;
        this.asignaturaRepository = asignaturaRepository;
    }

    public Anotacion guardar(AnotacionRequest request) {
        Asignatura asignatura = asignaturaRepository.findById(request.getIdAsignatura())
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));

        String tipo = clasificarAnotacion(request.getDescripcion());

        Anotacion anotacion = Anotacion.builder()
                .estudiante(request.getEstudiante())
                .descripcion(request.getDescripcion())
                .tipo(tipo)
                .fecha(LocalDate.now())
                .asignatura(asignatura)
                .build();

        return anotacionRepository.save(anotacion);
    }

    public String clasificarAnotacion(String descripcion) {
        String texto = descripcion.toLowerCase();

        if (texto.contains("felicitaciones") ||
            texto.contains("responsable") ||
            texto.contains("participa") ||
            texto.contains("excelente")) {
            return "POSITIVA";
        }

        return "NEGATIVA";
    }

    public List<Anotacion> listar() {
        return anotacionRepository.findAll();
    }

    public void eliminar(Long id) {
        anotacionRepository.deleteById(id);
    }
}