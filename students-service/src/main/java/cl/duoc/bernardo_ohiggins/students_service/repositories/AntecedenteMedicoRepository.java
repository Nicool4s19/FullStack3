package cl.duoc.bernardo_ohiggins.students_service.repositories;

import cl.duoc.bernardo_ohiggins.students_service.models.entities.AntecedenteMedico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AntecedenteMedicoRepository extends JpaRepository<AntecedenteMedico, Long> {
    List<AntecedenteMedico> findByEstudianteIdEstudiante(Long idEstudiante);
}
