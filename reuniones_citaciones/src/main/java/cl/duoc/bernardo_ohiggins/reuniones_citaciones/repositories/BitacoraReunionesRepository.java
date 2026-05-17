package cl.duoc.bernardo_ohiggins.reuniones_citaciones.repositories;

import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.entities.BitacoraReuniones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BitacoraReunionesRepository extends JpaRepository<BitacoraReuniones, Long> {
}