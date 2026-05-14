package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.controller;

import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Direccion;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.requests.CrearDireccionRequest;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.services.DireccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping
    public Mono<ResponseEntity<Direccion>> crear(@RequestBody CrearDireccionRequest request) {
        return Mono.fromCallable(() -> direccionService.crear(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<Direccion> listar() {
        return Flux.defer(() -> Flux.fromIterable(direccionService.listar()))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Direccion>> buscarPorId(@PathVariable Long id) {
        return Mono.fromCallable(() -> direccionService.buscarPorId(id))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }
}
