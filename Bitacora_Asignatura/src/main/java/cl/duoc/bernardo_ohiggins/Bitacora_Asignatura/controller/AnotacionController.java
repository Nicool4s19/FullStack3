package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.controller;

import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities.Anotacion;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.requests.AnotacionRequest;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.services.AnotacionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api/anotaciones")
public class AnotacionController {

    private final AnotacionService anotacionService;

    public AnotacionController(AnotacionService anotacionService) {
        this.anotacionService = anotacionService;
    }

    @PostMapping
    public Mono<ResponseEntity<Anotacion>> guardar(
            @Valid @RequestBody AnotacionRequest request) {

        return Mono.fromCallable(() -> anotacionService.guardar(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<Anotacion> listar() {
        return Flux.defer(() -> Flux.fromIterable(anotacionService.listar()))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminar(@PathVariable Long id) {

        return Mono.fromRunnable(() -> anotacionService.eliminar(id))
                .subscribeOn(Schedulers.boundedElastic())
                .thenReturn(ResponseEntity.noContent().build());
    }
}