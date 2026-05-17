package cl.duoc.bernardo_ohiggins.mensajeria_service.repositories;

import cl.duoc.bernardo_ohiggins.mensajeria_service.models.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    List<Mensaje> findByIdRemitente(Long idRemitente);

    List<Mensaje> findByIdDestinatario(Long idDestinatario);

    List<Mensaje> findByIdDestinatarioAndLeido(Long idDestinatario, Boolean leido);
}