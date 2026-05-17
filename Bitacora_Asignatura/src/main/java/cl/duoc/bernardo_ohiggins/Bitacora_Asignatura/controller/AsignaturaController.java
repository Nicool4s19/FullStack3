package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.controller;

import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities.Asignatura;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.requests.AsignaturaRequest;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.services.AsignaturaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @PostMapping
    public Mono<ResponseEntity<Asignatura>> guardar(
            @Valid @RequestBody AsignaturaRequest request) {

        return Mono.fromCallable(() -> asignaturaService.guardar(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<Asignatura> listar() {
        return Flux.defer(() -> Flux.fromIterable(asignaturaService.listar()))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Asignatura>> buscarPorId(@PathVariable Long id) {

        return Mono.fromCallable(() -> asignaturaService.buscarPorId(id))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminar(@PathVariable Long id) {

        return Mono.fromRunnable(() -> asignaturaService.eliminar(id))
                .subscribeOn(Schedulers.boundedElastic())
                .thenReturn(ResponseEntity.noContent().build());
    }
}