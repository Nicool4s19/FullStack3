package cl.duoc.bernardo_ohiggins.students_service.repositories;

import cl.duoc.bernardo_ohiggins.students_service.models.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findByEstudianteIdEstudiante(Long idEstudiante);
}