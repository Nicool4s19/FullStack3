package com.infraestructura.academica.controller;

import com.infraestructura.academica.models.entities.Nivel;
import com.infraestructura.academica.models.requests.NivelRequest;
import com.infraestructura.academica.services.NivelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/niveles")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @GetMapping
    public ResponseEntity<List<Nivel>> getAllNiveles() {
        return ResponseEntity.ok(nivelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nivel> getNivelById(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(nivelService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Nivel> createNivel(@Valid @RequestBody NivelRequest request) {
        return new ResponseEntity<>(nivelService.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nivel> updateNivel(@PathVariable @NonNull Long id, @Valid @RequestBody NivelRequest request) {
        return ResponseEntity.ok(nivelService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNivel(@PathVariable @NonNull Long id) {
        nivelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
