package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.repositories;

import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities.Anotacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotacionRepository extends JpaRepository<Anotacion, Long> {
}