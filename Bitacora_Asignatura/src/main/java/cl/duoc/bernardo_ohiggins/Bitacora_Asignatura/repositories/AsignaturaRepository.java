package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.repositories;

import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}