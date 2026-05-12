package com.infraestructura.academica.services;

import com.infraestructura.academica.models.entities.Nivel;
import com.infraestructura.academica.models.requests.NivelRequest;
import com.infraestructura.academica.repositories.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelService {

    @Autowired
    private NivelRepository nivelRepository;

    public List<Nivel> findAll() {
        return nivelRepository.findAll();
    }

    public Nivel findById(Long id) {
        return nivelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nivel no encontrado con ID: " + id));
    }

    public Nivel save(NivelRequest request) {
        Nivel nivel = Nivel.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .build();
        return nivelRepository.save(nivel);
    }

    public Nivel update(Long id, NivelRequest request) {
        Nivel nivel = findById(id);
        nivel.setNombre(request.getNombre());
        nivel.setDescripcion(request.getDescripcion());
        return nivelRepository.save(nivel);
    }

    public void delete(Long id) {
        Nivel nivel = findById(id);
        nivelRepository.delete(nivel);
    }
}
