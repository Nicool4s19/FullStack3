package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.repositories;

import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
