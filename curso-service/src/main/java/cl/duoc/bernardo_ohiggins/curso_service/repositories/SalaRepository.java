package cl.duoc.bernardo_ohiggins.curso_service.repositories;

import cl.duoc.bernardo_ohiggins.curso_service.models.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
}