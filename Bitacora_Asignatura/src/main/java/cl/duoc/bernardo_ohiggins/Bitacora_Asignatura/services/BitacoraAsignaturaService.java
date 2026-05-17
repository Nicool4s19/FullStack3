package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.services;

import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities.Asignatura;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities.BitacoraAsignatura;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.requests.BitacoraAsignaturaRequest;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.repositories.AsignaturaRepository;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.repositories.BitacoraAsignaturaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BitacoraAsignaturaService {

    private final BitacoraAsignaturaRepository bitacoraRepository;
    private final AsignaturaRepository asignaturaRepository;

    public BitacoraAsignaturaService(BitacoraAsignaturaRepository bitacoraRepository,
                                     AsignaturaRepository asignaturaRepository) {
        this.bitacoraRepository = bitacoraRepository;
        this.asignaturaRepository = asignaturaRepository;
    }

    public BitacoraAsignatura guardar(BitacoraAsignaturaRequest request) {
        Asignatura asignatura = asignaturaRepository.findById(request.getIdAsignatura())
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));

        BitacoraAsignatura bitacora = BitacoraAsignatura.builder()
                .asignatura(asignatura)
                .fecha(LocalDate.now())
                .observacion(request.getObservacion())
                .build();

        return bitacoraRepository.save(bitacora);
    }

    public List<BitacoraAsignatura> listar() {
        return bitacoraRepository.findAll();
    }

    public void eliminar(Long id) {
        bitacoraRepository.deleteById(id);
    }
}