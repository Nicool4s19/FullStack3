package cl.duoc.bernardo_ohiggins.curso_service.controller;

import cl.duoc.bernardo_ohiggins.curso_service.models.entities.Curso;
import cl.duoc.bernardo_ohiggins.curso_service.models.requests.CursoRequest;
import cl.duoc.bernardo_ohiggins.curso_service.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(cursoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(cursoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Curso> crear(@Valid @RequestBody CursoRequest request) {
        return new ResponseEntity<>(
                cursoService.crear(request),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(
            @PathVariable @NonNull Long id,
            @Valid @RequestBody CursoRequest request
    ) {
        return ResponseEntity.ok(
                cursoService.actualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable @NonNull Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}