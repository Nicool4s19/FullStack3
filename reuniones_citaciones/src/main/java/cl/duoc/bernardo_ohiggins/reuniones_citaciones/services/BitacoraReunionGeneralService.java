package cl.duoc.bernardo_ohiggins.reuniones_citaciones.services;

import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.entities.BitacoraReunionGeneral;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.requests.BitacoraReunionGeneralRequest;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.repositories.BitacoraReunionGeneralRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BitacoraReunionGeneralService {

    private final BitacoraReunionGeneralRepository repository;

    public BitacoraReunionGeneralService(BitacoraReunionGeneralRepository repository) {
        this.repository = repository;
    }

    public BitacoraReunionGeneral guardar(BitacoraReunionGeneralRequest request) {
        BitacoraReunionGeneral reunion = BitacoraReunionGeneral.builder()
                .tema(request.getTema())
                .observacion(request.getObservacion())
                .participantes(request.getParticipantes())
                .fechaRegistro(LocalDateTime.now())
                .build();

        return repository.save(reunion);
    }

    public List<BitacoraReunionGeneral> listar() {
        return repository.findAll();
    }

    public BitacoraReunionGeneral buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bitácora general no encontrada"));
    }

    public BitacoraReunionGeneral editar(Long id, BitacoraReunionGeneralRequest request) {
        BitacoraReunionGeneral reunion = buscarPorId(id);

        reunion.setTema(request.getTema());
        reunion.setObservacion(request.getObservacion());
        reunion.setParticipantes(request.getParticipantes());

        return repository.save(reunion);
    }

    public void eliminar(Long id) {
        BitacoraReunionGeneral reunion = buscarPorId(id);
        repository.delete(reunion);
    }
}