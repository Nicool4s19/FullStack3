package cl.duoc.bernardo_ohiggins.curso_service.controller;

import cl.duoc.bernardo_ohiggins.curso_service.models.entities.Sala;
import cl.duoc.bernardo_ohiggins.curso_service.models.requests.SalaRequest;
import cl.duoc.bernardo_ohiggins.curso_service.services.SalaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public ResponseEntity<List<Sala>> listar() {
        return ResponseEntity.ok(salaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(salaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Sala> crear(@Valid @RequestBody SalaRequest request) {
        return new ResponseEntity<>(
                salaService.crear(request),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> actualizar(
            @PathVariable @NonNull Long id,
            @Valid @RequestBody SalaRequest request
    ) {
        return ResponseEntity.ok(
                salaService.actualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable @NonNull Long id) {
        salaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}