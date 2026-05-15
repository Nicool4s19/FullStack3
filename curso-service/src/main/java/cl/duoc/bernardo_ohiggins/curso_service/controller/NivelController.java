package cl.duoc.bernardo_ohiggins.curso_service.controller;

import cl.duoc.bernardo_ohiggins.curso_service.models.entities.Nivel;
import cl.duoc.bernardo_ohiggins.curso_service.models.requests.NivelRequest;
import cl.duoc.bernardo_ohiggins.curso_service.services.NivelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/niveles")
public class NivelController {

    private final NivelService nivelService;

    public NivelController(NivelService nivelService) {
        this.nivelService = nivelService;
    }

    @GetMapping
    public ResponseEntity<List<Nivel>> listar() {
        return ResponseEntity.ok(nivelService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nivel> buscarPorId(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(nivelService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Nivel> crear(@Valid @RequestBody NivelRequest request) {
        return new ResponseEntity<>(
                nivelService.crear(request),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nivel> actualizar(
            @PathVariable @NonNull Long id,
            @Valid @RequestBody NivelRequest request
    ) {
        return ResponseEntity.ok(
                nivelService.actualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable @NonNull Long id) {
        nivelService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}