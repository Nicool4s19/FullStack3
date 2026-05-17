package cl.duoc.bernardo_ohiggins.mensajeria_service.services;

import cl.duoc.bernardo_ohiggins.mensajeria_service.models.entities.Mensaje;
import cl.duoc.bernardo_ohiggins.mensajeria_service.models.requests.CrearMensajeRequest;
import cl.duoc.bernardo_ohiggins.mensajeria_service.repositories.MensajeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensajeService {

    private final MensajeRepository mensajeRepository;

    public MensajeService(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    public Mensaje crear(CrearMensajeRequest request) {
        Mensaje mensaje = Mensaje.builder()
                .idRemitente(request.getIdRemitente())
                .idDestinatario(request.getIdDestinatario())
                .asunto(request.getAsunto())
                .contenidoMensaje(request.getContenidoMensaje())
                .fechaMensaje(LocalDateTime.now())
                .leido(false)
                .estadoMensaje("ENVIADO")
                .build();

        return mensajeRepository.save(mensaje);
    }

    public List<Mensaje> listar() {
        return mensajeRepository.findAll();
    }

    public Mensaje buscarPorId(Long id) {
        return mensajeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensaje no encontrado"));
    }

    public List<Mensaje> buscarPorRemitente(Long idRemitente) {
        return mensajeRepository.findByIdRemitente(idRemitente);
    }

    public List<Mensaje> buscarPorDestinatario(Long idDestinatario) {
        return mensajeRepository.findByIdDestinatario(idDestinatario);
    }

    public List<Mensaje> buscarNoLeidosPorDestinatario(Long idDestinatario) {
        return mensajeRepository.findByIdDestinatarioAndLeido(idDestinatario, false);
    }

    public Mensaje marcarComoLeido(Long id) {
        Mensaje mensaje = buscarPorId(id);
        mensaje.setLeido(true);
        mensaje.setEstadoMensaje("LEIDO");
        return mensajeRepository.save(mensaje);
    }

    public void eliminar(Long id) {
        Mensaje mensaje = buscarPorId(id);
        mensajeRepository.delete(mensaje);
    }
}
