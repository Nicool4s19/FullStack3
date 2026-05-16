package Bernardo_Ohiggins.mural_calendario.repositories;

import Bernardo_Ohiggins.mural_calendario.models.entities.MuralDigital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuralDigitalRepository extends JpaRepository<MuralDigital, Long> {
}