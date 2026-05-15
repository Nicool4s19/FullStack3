package cl.duoc.bernardo_ohiggins.students_service.repositories;

import cl.duoc.bernardo_ohiggins.students_service.models.entities.AntecedenteAcademico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AntecedenteAcademicoRepository extends JpaRepository<AntecedenteAcademico, Long> {
    List<AntecedenteAcademico> findByEstudianteIdEstudiante(Long idEstudiante);
}