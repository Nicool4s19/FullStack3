package cl.duoc.bernardo_ohiggins.reuniones_citaciones.services;

import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.entities.BitacoraReuniones;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.requests.BitacoraReunionesRequest;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.repositories.BitacoraReunionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BitacoraReunionesService {

    private final BitacoraReunionesRepository repository;

    public BitacoraReunionesService(BitacoraReunionesRepository repository) {
        this.repository = repository;
    }

    public BitacoraReuniones guardar(BitacoraReunionesRequest request) {
        BitacoraReuniones reunion = BitacoraReuniones.builder()
                .titulo(request.getTitulo())
                .descripcion(request.getDescripcion())
                .encargado(request.getEncargado())
                .fechaReunion(request.getFechaReunion())
                .estado("ACTIVA")
                .build();

        return repository.save(reunion);
    }

    public List<BitacoraReuniones> listar() {
        return repository.findAll();
    }

    public BitacoraReuniones buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reunión no encontrada"));
    }

    public BitacoraReuniones editar(Long id, BitacoraReunionesRequest request) {
        BitacoraReuniones reunion = buscarPorId(id);

        reunion.setTitulo(request.getTitulo());
        reunion.setDescripcion(request.getDescripcion());
        reunion.setEncargado(request.getEncargado());
        reunion.setFechaReunion(request.getFechaReunion());

        return repository.save(reunion);
    }

    public void eliminar(Long id) {
        BitacoraReuniones reunion = buscarPorId(id);
        repository.delete(reunion);
    }
}