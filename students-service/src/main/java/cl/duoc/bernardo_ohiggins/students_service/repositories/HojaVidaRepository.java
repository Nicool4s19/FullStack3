package cl.duoc.bernardo_ohiggins.students_service.repositories;

import cl.duoc.bernardo_ohiggins.students_service.models.entities.HojaVidaEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HojaVidaRepository extends JpaRepository<HojaVidaEstudiante, Long> {
    Optional<HojaVidaEstudiante> findByEstudianteIdEstudiante(Long idEstudiante);
}