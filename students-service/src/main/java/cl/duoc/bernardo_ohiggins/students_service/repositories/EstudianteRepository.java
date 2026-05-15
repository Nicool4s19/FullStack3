package cl.duoc.bernardo_ohiggins.students_service.repositories;

import cl.duoc.bernardo_ohiggins.students_service.models.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Optional<Estudiante> findByRut(String rut);
}