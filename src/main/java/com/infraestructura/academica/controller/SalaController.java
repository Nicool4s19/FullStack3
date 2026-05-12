package com.infraestructura.academica.controller;

import com.infraestructura.academica.models.entities.Sala;
import com.infraestructura.academica.models.requests.SalaRequest;
import com.infraestructura.academica.services.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    public ResponseEntity<List<Sala>> getAllSalas() {
        return ResponseEntity.ok(salaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> getSalaById(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(salaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Sala> createSala(@Valid @RequestBody SalaRequest request) {
        return new ResponseEntity<>(salaService.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> updateSala(@PathVariable @NonNull Long id, @Valid @RequestBody SalaRequest request) {
        return ResponseEntity.ok(salaService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable @NonNull Long id) {
        salaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
