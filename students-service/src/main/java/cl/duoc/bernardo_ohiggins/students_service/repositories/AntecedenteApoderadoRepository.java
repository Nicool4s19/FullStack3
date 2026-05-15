package cl.duoc.bernardo_ohiggins.students_service.repositories;

import cl.duoc.bernardo_ohiggins.students_service.models.entities.AntecedenteApoderado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AntecedenteApoderadoRepository extends JpaRepository<AntecedenteApoderado, Long> {
    List<AntecedenteApoderado> findByEstudianteIdEstudiante(Long idEstudiante);
}
