package cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.controller;

import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.entities.BitacoraAsignatura;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.models.requests.BitacoraAsignaturaRequest;
import cl.duoc.bernardo_ohiggins.Bitacora_Asignatura.services.BitacoraAsignaturaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api/bitacoras")
public class BitacoraAsignaturaController {

    private final BitacoraAsignaturaService bitacoraService;

    public BitacoraAsignaturaController(BitacoraAsignaturaService bitacoraService) {
        this.bitacoraService = bitacoraService;
    }

    @PostMapping
    public Mono<ResponseEntity<BitacoraAsignatura>> guardar(
            @Valid @RequestBody BitacoraAsignaturaRequest request) {

        return Mono.fromCallable(() -> bitacoraService.guardar(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<BitacoraAsignatura> listar() {
        return Flux.defer(() -> Flux.fromIterable(bitacoraService.listar()))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminar(@PathVariable Long id) {

        return Mono.fromRunnable(() -> bitacoraService.eliminar(id))
                .subscribeOn(Schedulers.boundedElastic())
                .thenReturn(ResponseEntity.noContent().build());
    }
}