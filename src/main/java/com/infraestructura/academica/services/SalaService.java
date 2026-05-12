package com.infraestructura.academica.services;

import com.infraestructura.academica.models.entities.Sala;
import com.infraestructura.academica.models.requests.SalaRequest;
import com.infraestructura.academica.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> findAll() {
        return salaRepository.findAll();
    }

    public Sala findById(Long id) {
        return salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala no encontrada con ID: " + id));
    }

    public Sala save(SalaRequest request) {
        Sala sala = Sala.builder()
                .nombre(request.getNombre())
                .capacidad(request.getCapacidad())
                .ubicacion(request.getUbicacion())
                .build();
        return salaRepository.save(sala);
    }

    public Sala update(Long id, SalaRequest request) {
        Sala sala = findById(id);
        sala.setNombre(request.getNombre());
        sala.setCapacidad(request.getCapacidad());
        sala.setUbicacion(request.getUbicacion());
        return salaRepository.save(sala);
    }

    public void delete(Long id) {
        Sala sala = findById(id);
        salaRepository.delete(sala);
    }
}
