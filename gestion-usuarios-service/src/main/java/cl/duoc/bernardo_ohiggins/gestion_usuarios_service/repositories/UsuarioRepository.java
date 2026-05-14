package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.repositories;

import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByRut(String rut);
}
