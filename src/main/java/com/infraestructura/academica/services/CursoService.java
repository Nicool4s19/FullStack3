package com.infraestructura.academica.services;

import com.infraestructura.academica.models.entities.Curso;
import com.infraestructura.academica.models.entities.Nivel;
import com.infraestructura.academica.models.requests.CursoRequest;
import com.infraestructura.academica.repositories.CursoRepository;
import com.infraestructura.academica.repositories.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private NivelRepository nivelRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
    }

    public Curso save(CursoRequest request) {
        Nivel nivel = nivelRepository.findById(java.util.Objects.requireNonNull(request.getNivelId()))
                .orElseThrow(() -> new RuntimeException("Nivel no encontrado con ID: " + request.getNivelId()));

        Curso curso = Curso.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .nivel(nivel)
                .build();
        return cursoRepository.save(curso);
    }

    public Curso update(Long id, CursoRequest request) {
        Curso curso = findById(id);
        Nivel nivel = nivelRepository.findById(java.util.Objects.requireNonNull(request.getNivelId()))
                .orElseThrow(() -> new RuntimeException("Nivel no encontrado con ID: " + request.getNivelId()));

        curso.setNombre(request.getNombre());
        curso.setDescripcion(request.getDescripcion());
        curso.setNivel(nivel);
        return cursoRepository.save(curso);
    }

    public void delete(Long id) {
        Curso curso = findById(id);
        cursoRepository.delete(curso);
    }
}
