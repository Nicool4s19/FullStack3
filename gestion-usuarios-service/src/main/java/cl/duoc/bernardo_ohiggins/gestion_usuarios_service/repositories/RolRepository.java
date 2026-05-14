package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.repositories;

import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombreRol(String nombreRol);
}
